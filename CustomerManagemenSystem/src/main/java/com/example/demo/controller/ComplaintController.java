package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CustomerComplaint;
import com.example.demo.service.ComplaintService;

@RestController
@RequestMapping("/api")
public class ComplaintController {

	@Autowired
	ComplaintService comser;

	public ComplaintController(ComplaintService comser) {
		super();
		this.comser = comser;
	}

	@GetMapping("/getdetails")
	public ResponseEntity<List<CustomerComplaint>> getComplaint() {
		List<CustomerComplaint> allComplaint = comser.getComplaint();
		return new ResponseEntity<>(allComplaint, HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<CustomerComplaint> getComplaint(@PathVariable("id") int theId) {
		Optional<CustomerComplaint> theComp = comser.getComplaint(theId);
		return new ResponseEntity<CustomerComplaint>(HttpStatus.OK);
	}

	@RequestMapping(value = "/addComplaint", method = RequestMethod.POST)
	public ResponseEntity<CustomerComplaint> addCustomer(@RequestBody CustomerComplaint customercomplaint) {
		CustomerComplaint theComp = comser.addComplaint(customercomplaint);
		return new ResponseEntity<>(theComp, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<CustomerComplaint> updateComplaint(@RequestBody CustomerComplaint customerscomplaint) {
		CustomerComplaint theComp = comser.updateComplaint(customerscomplaint);
		return new ResponseEntity<>(theComp, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public void deleteComplaint(@PathVariable("id") int theId) {
		comser.deleteComplaint(theId);
	}
}
