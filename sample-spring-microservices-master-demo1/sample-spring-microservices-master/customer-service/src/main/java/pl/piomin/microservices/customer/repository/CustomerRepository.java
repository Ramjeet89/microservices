package pl.piomin.microservices.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.piomin.microservices.customer.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	public Customer findOneByPesel(String pesel);

}
