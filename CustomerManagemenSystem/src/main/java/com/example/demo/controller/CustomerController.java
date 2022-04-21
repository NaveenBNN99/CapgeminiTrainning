package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CustomerPayload;
import com.example.demo.model.Customer;
import com.example.demo.model.CustomerComplaint;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/capi")
public class CustomerController {

	@Autowired
	public CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}

	@RequestMapping("/t")
	public String test() {
		return "Connected";
	}

	@GetMapping("/getCustomer")
	public ResponseEntity<List<Customer>> getCustomers() {
		List<Customer> allCustomers = customerService.getCustomers();
		return new ResponseEntity<>(allCustomers, HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") int theId) {
		Customer theCustomers = customerService.getCustomer(theId);
		return new ResponseEntity<>(theCustomers, HttpStatus.OK);

	}

	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	public ResponseEntity<Customer> addCustomer(@RequestBody CustomerPayload customerpayload) {
		Customer theCustomers = customerService.addCustomer(customerpayload);
		return new ResponseEntity<>(theCustomers, HttpStatus.OK);

	}

	@PostMapping("/update")
	public ResponseEntity<Customer> updateComplaint(@RequestBody Customer customer) {
		Customer theCustomers = customerService.updateComplaint(customer);
		return new ResponseEntity<>(theCustomers, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public void deleteCustomer(@PathVariable("id") int theId) {
		customerService.deleteCustomer(theId);
	}

}
