package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.CustomerComplaint;

public interface ComplaintRepo  extends JpaRepository<CustomerComplaint,Integer>  {

}
