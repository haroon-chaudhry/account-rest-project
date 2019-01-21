package com.innovadeltech.account.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.innovadeltech.account.model.AccountHolder;

public class AccountHolderRepositoryTest {

	private AccountHolderRepositry repository = new AccountHolderRepositoryImpl();
	private AccountHolder mockAccountHolder;
	
	@Before
	public void setup() {
		Map<Integer, AccountHolder> database = new HashMap<>();
		database.put(1, new AccountHolder(1, "Mark", "Twain", "12345"));
		database.put(2, new AccountHolder(2, "David", "Wills", "45678"));
		
		repository.setAccountDatabase(database);
	}

	@Test
	public void testFindOneNotFound() {
		AccountHolder accountHolder = repository.findOne(3);
		assertNull(accountHolder);
	}
	
	@Test
	public void testFindOneFound() {
		AccountHolder accountHolder = repository.findOne(1);
		assertNotNull(accountHolder);
	}

	@Test
	public void testFindAllNoRecords() {
		repository.setAccountDatabase(new HashMap<Integer, AccountHolder>());
		List<AccountHolder> accountHolders = repository.findAll();
		assertEquals(0, accountHolders.size());
	}
	
	@Test
	public void testFindAllRecordsFound() {
		List<AccountHolder> accountHolders = repository.findAll();
		assertEquals(2, accountHolders.size());
	}

	@Test
	public void testCreate() {
		AccountHolder mockAccountHolder = new AccountHolder(null, "David", "Boon", "14567");
		repository.create(mockAccountHolder);
		assertNotNull(mockAccountHolder.getId());
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented"); // TODO
	}
}
