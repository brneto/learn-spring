package com.pluralsight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pluralsight.model.Customer;
import com.pluralsight.repository.CustomerRepository;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	// Annotation for Member Variable Injection
	//@Autowired
	private CustomerRepository customerRepository;
	
	public CustomerServiceImpl() {
		super();
		System.out.println("We've created the service object");
	}
	
	// Annotation for Constructor Injection
	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		System.out.println("We are using constructor injection");
		this.customerRepository = customerRepository;
	}

	// Annotation for Setter Injection
	//@Autowired
	public void setCustomerRepository(CustomerRepository customerRepository) {
		System.out.println("We are using setter injection");
		this.customerRepository = customerRepository;
	}

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

}
