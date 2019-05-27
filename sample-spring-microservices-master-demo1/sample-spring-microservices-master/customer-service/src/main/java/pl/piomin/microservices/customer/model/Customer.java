package pl.piomin.microservices.customer.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Customer {

	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String pesel;
	private String name;
	private CustomerType type;
	
	@Transient
	private List<Account> accounts;

	public Customer() {
		
	}
	
	public Customer(Integer id, String pesel, String name, CustomerType type) {
		this.id = id;
		this.pesel = pesel;
		this.name = name;
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CustomerType getType() {
		return type;
	}

	public void setType(CustomerType type) {
		this.type = type;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

}
