package com.example.demo.user;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface LoginService {
   
	void saveLogin(Login l);
	
    
	Login update(Login l,String username);
	
	List<Login> findByusername(String username);
	Login findByuserpassword(String userpassword);
}