package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.exception.CustomersNotFoundException;
import com.example.demo.model.CustomerComplaint;
import com.example.demo.model.CustomerPayload;
import com.example.demo.model.Customer;
import com.example.demo.repositories.ComplaintRepo;

@Service
public class ComplaintService {
	
	
	@Autowired
	ComplaintRepo comrepo;

	public List<CustomerComplaint> getComplaint() {
		// TODO Auto-generated method stub
		return comrepo.findAll();
	}

	public Optional<CustomerComplaint> getComplaint(int theId) {
		// TODO Auto-generated method stub
		return comrepo.findById(theId);
	}

	public CustomerComplaint addComplaint(CustomerComplaint complaint) {
		// TODO Auto-generated method stub
		return comrepo.save(complaint);
	}

	public CustomerComplaint updateComplaint(CustomerComplaint customerscomplaint) {
		// TODO Auto-generated method stub
		return comrepo.save(customerscomplaint);
	}

	public void deleteComplaint(int theId) {
		// TODO Auto-generated method stub
		comrepo.deleteById(theId);
		
	}
	

}
