package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerPayload {
	@JsonProperty("cid")
	private int cid;
	
	@JsonProperty("firstName")
	private String firstname;
	
	@JsonProperty("lastName")
	private String lastname;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("mobile")
	private String mobile;
	
	@JsonProperty("country")
	private String country;
	
	@JsonProperty("address")
	private String address;
	
	@JsonProperty("city")
	private String city;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	
	
}
