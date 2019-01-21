/**
 * 
 */
package com.innovadeltech.account.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.innovadeltech.account.model.AccountHolder;
import com.innovadeltech.account.repository.AccountHolderRepositoryImpl;
import com.innovadeltech.account.repository.AccountHolderRepositry;

/**
 * @author haroon-chaudhry
 *
 */
public class AccountHolderServiceImpl implements AccountHolderService {
	
	private AccountHolderRepositry repository;
	
	public AccountHolderServiceImpl() {
		repository = new AccountHolderRepositoryImpl();
	}
	
	public AccountHolderServiceImpl(AccountHolderRepositry repository) {
		this.repository = repository;
	}

	/* (non-Javadoc)
	 * @see com.innovadeltech.account.service.AccountHolderService#getAccountHolder(java.lang.Integer)
	 */
	@Override
	public AccountHolder getAccountHolder(Integer id) {
		
		if(id == null)
		{
			throw new IllegalArgumentException("Id should not be null");
		}
		
		AccountHolder accountHolder = repository.findOne(id);
		
		if(accountHolder == null) {
			throw new NoSuchElementException("The account holder is not found");
		}
		
		return accountHolder;
	}

	/* (non-Javadoc)
	 * @see com.innovadeltech.account.service.AccountHolderService#getAccountHolders()
	 */
	@Override
	public List<AccountHolder> getAccountHolders() {
		return repository.findAll();
	}

	/* (non-Javadoc)
	 * @see com.innovadeltech.account.service.AccountHolderService#add(com.innovadeltech.account.model.AccountHolder)
	 */
	@Override
	public boolean add(AccountHolder accountHolder) {
		if (accountHolder.getAccountNumber() == null || 
				accountHolder.getFirstName() == null ||
				accountHolder.getLastName() == null) {
			
			throw new IllegalArgumentException("Missing parameters for create account");
		}
		
		return false;
	}

	/* (non-Javadoc)
	 * @see com.innovadeltech.account.service.AccountHolderService#delete(java.lang.Integer)
	 */
	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

}
