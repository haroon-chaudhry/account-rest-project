package com.innovadeltech.account.repository;

import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.innovadeltech.account.model.AccountHolder;

import junit.framework.Assert;

public class AccountHolderRepositoryTest {

	private AccountHolderRepositry repository = new AccountHolderRepositoryImpl();
	private AccountHolder mockAccountHolder;
	
	@Before
	public void setup() {
		Map<Integer, AccountHolder> database = new HashMap<>();
		database.put(1, new AccountHolder(1, "Mark", "Twain", "12345"));
		database.put(2, new AccountHolder(2, "David", "Wills", "45678"));
		
		mockAccountHolder = new AccountHolder(4, "David", "Boon", "14567");
		repository.setAccountDatabase(database);
	}

	@Test
	public void testFindOneNotFound() {
		AccountHolder accountHolder = repository.findOne(3);
		Assert.assertNull(accountHolder);
	}
	
	@Test
	public void testFindOneFound() {
		AccountHolder accountHolder = repository.findOne(1);
		Assert.assertNotNull(accountHolder);
	}

	@Test
	public void testFindAll() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testCreate() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented"); // TODO
	}
}
