package com.pluralsight.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.pluralsight.model.Customer;

@Repository("customerRepository")
public class HibernateCustomerRepositoryImpl implements CustomerRepository {
	
	public HibernateCustomerRepositoryImpl() {
		super();
		System.out.println("We've created the repository object");
	}

	@Override
	public List<Customer> findAll() {
		List<Customer> customers = new ArrayList<>();

		Customer customer = new Customer();

		customer.setFirstname("Berchris");
		customer.setLastname("Requiao");

		customers.add(customer);

		return customers;
	}
}
