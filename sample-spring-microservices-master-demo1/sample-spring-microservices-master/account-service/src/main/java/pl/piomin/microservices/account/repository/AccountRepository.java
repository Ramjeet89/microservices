package pl.piomin.microservices.account.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.piomin.microservices.account.model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

	public Account findOneByNumber(String number);

	public List<Account> findByCustomerId(Integer customerId);
}
