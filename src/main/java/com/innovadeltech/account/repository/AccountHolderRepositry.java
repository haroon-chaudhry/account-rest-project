/**
 * 
 */
package com.innovadeltech.account.repository;

import java.util.List;
import java.util.Map;

import com.innovadeltech.account.model.AccountHolder;

/**
 * @author haroon-chaudhry
 *
 */
public interface AccountHolderRepositry {
	public AccountHolder findOne(Integer id);
	public List<AccountHolder> findAll();
	public boolean create(AccountHolder accountHolder);
	public boolean delete(Integer id);
	public void setAccountDatabase(Map<Integer, AccountHolder> database);
}
