package pl.piomin.microservices.account.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.piomin.microservices.account.model.Account;
import pl.piomin.microservices.account.service.AccountService;

@RestController
public class Api {

	@Autowired
	AccountService accountService;

	protected Logger logger = Logger.getLogger(Api.class.getName());

	public Api() {
//		accountService.initiateAccountData();
	}

	@RequestMapping("/accounts/{number}")
	public Account findByNumber(@PathVariable("number") String number) {
		logger.info(String.format("Account.findByNumber(%s)", number));
		// accounts.stream().filter(it ->
		// it.getNumber().equals(number)).findFirst().get();
		return accountService.getAccount(number);
	}

	@RequestMapping("/accounts/customer/{customer}")
	public List<Account> findByCustomer(@PathVariable("customer") Integer customerId) {
		logger.info(String.format("Account.findByCustomer(%s)", customerId));
		// accounts.stream().filter(it ->
		// it.getCustomerId().intValue()==customerId.intValue()).collect(Collectors.toList());
		return accountService.getAccountsByCustomer(customerId);
	}

	@RequestMapping("/accounts")
	public List<Account> findAll() {
		logger.info("Account.findAll()");
		return accountService.getAllAccounts();
	}

}
