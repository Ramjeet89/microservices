package pl.piomin.microservices.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.piomin.microservices.account.model.Account;
import pl.piomin.microservices.account.repository.AccountRepository;

@Component
public class AccountService {
	
	@Autowired
	AccountRepository accountRepository;
	
	public void initiateAccountData() {
		Account acc=new Account(1, 1, "111111");
		accountRepository.save(acc);
		
		acc=new Account(2, 2, "222222");
		accountRepository.save(acc);
		
		acc=new Account(3, 3, "333333");
		accountRepository.save(acc);
		
		acc=new Account(4, 4, "444444");
		accountRepository.save(acc);
		
	    acc=new Account(5, 1, "555555");
		accountRepository.save(acc);
		
		acc=new Account(6, 2, "666666");
		accountRepository.save(acc);
		
		acc=new Account(7, 2, "777777");
		accountRepository.save(acc);
		
	}

	public Account getAccount(String number) {
		
		return accountRepository.findOneByNumber(number);
	}
	public List<Account> getAccountsByCustomer(Integer customerId){
		return accountRepository.findByCustomerId(customerId);
	}
	public List<Account> getAllAccounts()
	{
		return accountRepository.findAll();
	}
}
