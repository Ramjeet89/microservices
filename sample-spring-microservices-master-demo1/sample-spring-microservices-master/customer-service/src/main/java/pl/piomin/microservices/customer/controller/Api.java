package pl.piomin.microservices.customer.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.piomin.microservices.customer.intercomm.AccountClient;
import pl.piomin.microservices.customer.model.Account;
import pl.piomin.microservices.customer.model.Customer;
import pl.piomin.microservices.customer.service.CustomerService;

@RestController
public class Api {

	@Autowired
	private AccountClient accountClient;
	@Autowired
	private CustomerService customerService;

	protected Logger logger = Logger.getLogger(Api.class.getName());

	public Api() {

	}

	@RequestMapping("/customers/pesel/{pesel}")
	public Customer findByPesel(@PathVariable("pesel") String pesel) {
		logger.info(String.format("Customer.findByPesel(%s)", pesel));
		// customers.stream().filter(it ->
		// it.getPesel().equals(pesel)).findFirst().get();
		return customerService.getCustomersByPeselr(pesel);
	}

	@RequestMapping("/customers")
	public List<Customer> findAll() {
		logger.info("Customer.findAll()");
		return customerService.getAllCustomers();
	}

	@RequestMapping("/customers/{id}")
	public Customer findById(@PathVariable("id") Integer id) {
		logger.info(String.format("Customer.findById(%s)", id));
		Customer customer = customerService.getCustomer(id);
		// customers.stream().filter(it ->
		// it.getId().intValue()==id.intValue()).findFirst().get();
		List<Account> accounts = accountClient.getAccounts(id);
		customer.setAccounts(accounts);
		return customer;
	}

}
