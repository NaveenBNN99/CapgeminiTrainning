package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.exception.CustomersNotFoundException;
import com.example.demo.model.CustomerPayload;
import com.example.demo.model.Customer;
import com.example.demo.model.CustomerComplaint;
import com.example.demo.repositories.CustomerRepository;

@Service("customerService")
public class CustomerService {
	
	@Autowired
	CustomerRepository customerrepository;
	
	
	public CustomerService(CustomerRepository customerrepository) {
		super();
		this.customerrepository = customerrepository;
	}
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customerrepository.findAll();
	}
	public Customer getCustomer(int theId) {
		// TODO Auto-generated method stub
		return customerrepository.findById(theId).orElseThrow(()-> new CustomersNotFoundException("The requied customer could not be found"));
	}

	public Customer addCustomer(CustomerPayload customerpayload) {
		// TODO Auto-generated method stub
		
		Customer customers = new Customer();
		customers.setCustomerid(customerpayload.getCid());
		customers.setFirstName(customerpayload.getFirstname());
		customers.setLastName(customerpayload.getLastname());
		customers.setEmail(customerpayload.getEmail());
		customers.setMobile(customerpayload.getMobile());
		customers.setCountry(customerpayload.getCountry());
		customers.setAddress(customerpayload.getAddress());
		customers.setCity(customerpayload.getCity());
		return customerrepository.save(customers);
	}

	/*public Customer updateCustomer(Customer customers) {
		// TODO Auto-generated method stub
		return customerrepository.save(customers);
	}*/
	public void deleteCustomer(int theId) {
		// TODO Auto-generated method stub
		customerrepository.deleteById(theId);
	}
	public Customer updateComplaint(Customer customer) {
		// TODO Auto-generated method stub
		return customerrepository.save(customer);
	}

	public Customer findById(int id) {
		Customer p= customerrepository.getById(id);
		return p;
	}

	

}
