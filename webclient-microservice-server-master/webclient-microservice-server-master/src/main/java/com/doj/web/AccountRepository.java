/**
 * 
 */
package com.doj.web;

import java.util.List;

/**
 * @author Ramjeet
 *
 */
public interface AccountRepository {
	
	List<Account> getAllAccounts();
	
	Account getAccount(String number);
}
