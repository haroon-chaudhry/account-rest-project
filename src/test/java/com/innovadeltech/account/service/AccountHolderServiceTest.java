package com.innovadeltech.account.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;

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
	
	@BeforeMethod
	public void beforeMethod() {
		MockitoAnnotations.initMocks(this);
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test (expected = IllegalArgumentException.class)
	public void testGetAccountHolderEmptyParams() {
		service.getAccountHolder(null);
	}
	
	@Test (expected = NoSuchElementException.class)
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
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetAccountHolders() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testAdd() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented"); // TODO
	}

}
