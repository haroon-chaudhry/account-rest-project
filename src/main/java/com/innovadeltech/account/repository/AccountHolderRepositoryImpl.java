/**
 * 
 */
package com.innovadeltech.account.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import com.innovadeltech.account.model.AccountHolder;

/**
 * @author haroon-chaudhry
 *
 */
public class AccountHolderRepositoryImpl implements AccountHolderRepositry{

	private static Map<Integer, AccountHolder> database = new HashMap<Integer, AccountHolder>();

	@Override
	public AccountHolder findOne(Integer id) {
		return database.get(id);
	}

	@Override
	public List<AccountHolder> findAll() {
		return database.entrySet().stream()
                .map(x -> x.getValue())
                .collect(Collectors.toList());
	}

	@Override
	public boolean create(AccountHolder accountHolder) {
		Random random = new Random();
		accountHolder.setId(random.nextInt());
		
		database.put(accountHolder.getId(), accountHolder);
		
		return true;
	}

	@Override
	public boolean delete(Integer id) {
		database.remove(id);
		return true;
	}

	@Override
	public void setAccountDatabase(Map<Integer, AccountHolder> database) {
		AccountHolderRepositoryImpl.database = database;
	}
	
	
}
