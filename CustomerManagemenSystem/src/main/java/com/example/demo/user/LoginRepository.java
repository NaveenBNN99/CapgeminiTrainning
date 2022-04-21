package com.example.demo.user;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Integer> {

	Login getByUsername(String username);

	void deleteByUsername(String username);

	Login getByUserpassword(String userpassword);

}
