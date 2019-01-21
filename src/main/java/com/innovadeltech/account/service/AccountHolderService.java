package com.innovadeltech.account.service;

import java.util.List;

import com.innovadeltech.account.model.AccountHolder;

/**
 * @author haroon-chaudhry
 *
 */
public interface AccountHolderService {
	public AccountHolder getAccountHolder(Integer id);
	public List<AccountHolder> getAccountHolders();
	public boolean add(AccountHolder accountHolder);
	public boolean delete(Integer id);
}
