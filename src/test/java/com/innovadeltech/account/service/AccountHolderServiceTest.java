package com.innovadeltech.account.service;

import static org.testng.AssertJUnit.assertFalse;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.innovadeltech.account.model.AccountHolder;
import com.innovadeltech.account.repository.AccountHolderRepositry;

/**
 * @author haroon-chaudhry
 *
 */
public class AccountHolderServiceTest {
	
	@Mock
	private AccountHolderRepositry repository;
	
	private AccountHolderService service;
	private AccountHolder expected;
	
	@BeforeMethod
	public void beforeMethod() {
		MockitoAnnotations.initMocks(this);
		service = new AccountHolderServiceImpl(repository);
		expected = new AccountHolder(1, "David", "Boon", "14567");
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test (expectedExceptions = IllegalArgumentException.class)
	public void testGetAccountHolderEmptyParams() {
		service.getAccountHolder(null);
	}
	
	@Test (expectedExceptions = NoSuchElementException.class)
	public void testGetAccountHolderNotFound() {
		Integer id = -1;
		when(repository.findOne(id)).thenReturn(null);
		service.getAccountHolder(id);
	}
	
	@Test
	public void testGetAccountHolderFound() 
	{
		int id = 1;
		when(repository.findOne(id)).thenReturn(expected);
		AccountHolder actual = service.getAccountHolder(id);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetAccountHoldersNotFound() {
		when(repository.findAll()).thenReturn(Collections.emptyList());
		List<AccountHolder> accountHolders = service.getAccountHolders();
		assertTrue(accountHolders.isEmpty());
	}

	@Test
	public void testGetAccountHoldersFound() {
		List<AccountHolder> expectedAccountHolders = new ArrayList<AccountHolder>();
		expectedAccountHolders.add(expected);
		
		when(repository.findAll()).thenReturn(expectedAccountHolders);
		List<AccountHolder> accountHolders = service.getAccountHolders();
		assertEquals(expectedAccountHolders, accountHolders);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testAddMissingParameters() {
		AccountHolder accountHolder = new AccountHolder();
		service.add(accountHolder);
	}
	
	@Test
	public void testAddSuccessful() {
		service.add(expected);
		verify(repository, times(1)).create(expected);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testDeleteMissingParameters() {
		service.delete(null);
	}
	
	@Test
	public void testDeleteFailed() {
		Integer id = -1;
		when(repository.delete(id)).thenReturn(false);
		boolean result = service.delete(id);
		
		verify(repository, times(1)).delete(id);
		assertFalse(result);
	}
	
	@Test
	public void testDeleteSuccessful() {
		Integer id = 1;
		when(repository.delete(id)).thenReturn(true);
		boolean result = service.delete(id);
		
		verify(repository, times(1)).delete(id);
		assertTrue(result);
	}
}
