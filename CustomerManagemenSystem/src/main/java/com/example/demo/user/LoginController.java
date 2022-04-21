package com.example.demo.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/userlogin")
public class LoginController {

	@Autowired
	CustomerService customerservice;
	@Autowired
	LoginService loginservices;

	@RequestMapping("login")
	public String tests() {
		return "test login controller";
	}

	@RequestMapping("/getlogin/{username},{userpassword}")
	public ResponseEntity<Login> findOne(@PathVariable(value = "username") String username,
			@PathVariable(value = "userpassword") String userpassword) {
		try {
			List<Login> log = loginservices.findByusername(username);
			if (log != null) {
				Login logpass = loginservices.findByuserpassword(userpassword);
				if (logpass != null) {

					System.out.println("valid");
					return new ResponseEntity<Login>(logpass, HttpStatus.FOUND);
				}

			}

			else {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			}
		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return null;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Customer> findOne(@PathVariable(value = "id") Integer id) {
		try {
			Customer customer = customerservice.findById(id);
			if (customer != null) {
				return new ResponseEntity<>(customer, HttpStatus.OK);

			} else {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			}

		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update")
	public ResponseEntity<Login> updatepass(@RequestBody Login l) {
		try {
			loginservices.update(l, l.getUsername());

			return new ResponseEntity<Login>(l, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}