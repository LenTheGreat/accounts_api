package com.metrobank.testapp;

import com.metrobank.testapp.dto.AccountsDTO;
import com.metrobank.testapp.model.Accounts;
import com.metrobank.testapp.repository.AccountsRepository;
import com.metrobank.testapp.service.AccountService;
import com.metrobank.testapp.service.impl.AccountServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TestappApplicationTests {
	@Autowired
	private MockMvc mockMvc;
	@Mock
	private AccountsRepository accountsRepository;

	@InjectMocks
	private AccountServiceImpl accountService;

// Unit Testing Service Layer (Viewing ALl accounts)
	@Test
	void shouldFindAndReturnAllAccounts(){

		when(accountsRepository.findAll()).thenReturn(List.of(new Accounts(), new Accounts())); // Returning the List of All Accounts when accessing the Repository

		assertThat(accountService.findAll()).hasSize(2); // Assume the total number of accounts
		verify(accountsRepository, times(1)).findAll(); // expected # of times the findALl() method is called in the repository
		verifyNoMoreInteractions(accountsRepository); // validate if there is no more interaction with the repository

	}
	@Test
	void shouldFindAnExistingAccountById(){
		long accountIdtoFind = 5L; // AccountId to Find

		// Assert that when findById() is called on the accountsRepository with the specific ID, return null
		when(accountsRepository.findById(accountIdtoFind)).thenReturn(null);

		// Call the findById() method of the accountService with the specific ID
		Accounts foundAccount = accountService.findById(accountIdtoFind);

		//Assuming that the returned Account is null
		assertThat(foundAccount).isNull();

		// Verify that the findById() method of the repository was called exactly once with the specific ID
		verify(accountsRepository, times(1)).findById(accountIdtoFind);

		// Verify that there are no more interactions with the repository
		verifyNoMoreInteractions(accountsRepository);
	}

	@Test
	void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/accounts")).andDo(print()).andExpect(status().isOk())
				.andExpect(content()
						.string(containsString("Greetings Stranger! - Service added me")));
	}



}
