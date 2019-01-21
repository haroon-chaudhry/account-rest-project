/**
 * 
 */
package com.innovadeltech.account.service;

import java.util.List;

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

	/* (non-Javadoc)
	 * @see com.innovadeltech.account.service.AccountHolderService#getAccountHolder(java.lang.Integer)
	 */
	@Override
	public AccountHolder getAccountHolder(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.innovadeltech.account.service.AccountHolderService#getAccountHolders()
	 */
	@Override
	public List<AccountHolder> getAccountHolders() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.innovadeltech.account.service.AccountHolderService#add(com.innovadeltech.account.model.AccountHolder)
	 */
	@Override
	public boolean add(AccountHolder accountHolder) {
		// TODO Auto-generated method stub
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
