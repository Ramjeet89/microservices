package pl.piomin.microservices.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.piomin.microservices.customer.model.Customer;
import pl.piomin.microservices.customer.model.CustomerType;
import pl.piomin.microservices.customer.repository.CustomerRepository;

@Component
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	public void initiateCustomerData() {
		Customer cust = new Customer(1, "12345", "Adam Kowalski", CustomerType.INDIVIDUAL);
		customerRepository.save(cust);

		cust = new Customer(2, "12346", "Anna Malinowska", CustomerType.INDIVIDUAL);
		customerRepository.save(cust);

		cust = new Customer(3, "12347", "Paweł Michalski", CustomerType.INDIVIDUAL);
		customerRepository.save(cust);

		cust = new Customer(4, "12348", "Karolina Lewandowska", CustomerType.INDIVIDUAL);
		customerRepository.save(cust);

	}

	public Customer getCustomer(Integer id) {

		return customerRepository.findOne(id);
	}

	public Customer getCustomersByPeselr(String pesel) {
		return customerRepository.findOneByPesel(pesel);
	}

	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}
}
