package com.innovadeltech.account.service;

import static org.mockito.Mockito.when;
import static org.testng.AssertJUnit.assertEquals;

import java.util.NoSuchElementException;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
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
	AccountHolderRepositry repository;
	
	private AccountHolderService service;
	
	@BeforeMethod
	public void beforeMethod() {
		MockitoAnnotations.initMocks(this);
		service = new AccountHolderServiceImpl(repository);
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
		AccountHolder expected = new AccountHolder(1, "David", "Boon", "14567");
		when(repository.findOne(id)).thenReturn(expected);
		AccountHolder actual = service.getAccountHolder(id);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetAccountHolder() {
		Assert.fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetAccountHolders() {
		Assert.fail("Not yet implemented"); // TODO
	}

	@Test
	public void testAdd() {
		Assert.fail("Not yet implemented"); // TODO
	}

	@Test
	public void testDelete() {
		Assert.fail("Not yet implemented"); // TODO
	}

}
