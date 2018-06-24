package com.sm1234.dao;

import com.sm1234.domain.Customer;

import java.util.List;


public interface CustomerDao {

	public void save(Customer customer);
	
	public List<Customer> findAll();

	public Customer findById(Long custId);

	public void update(Customer customer);

	public void delete(Long custId);
}
