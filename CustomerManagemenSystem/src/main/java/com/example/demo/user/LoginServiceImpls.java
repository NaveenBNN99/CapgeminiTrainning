package com.example.demo.user;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpls implements LoginService {
	@Autowired
	LoginRepository repo;
	
	@Override
	public void saveLogin(Login l) {
		repo.save(l);
	}
	
	@Override
	public Login  update(Login l ,String username) {
		Login lc=repo.getByUsername(username);
		lc.setUserpassword(l.getUserpassword());
		repo.save(lc);
	    return lc;
	
	}
	
	@Override
	public List<Login> findByusername(String username) {
		List<Login> u= repo.findAll();
		u=u.stream().filter(s->s.getUsername().contains(username)).collect(Collectors.toList());
	return u;
	}
	public Login findByuserpassword(String userpassword) {
		Login u= repo.getByUserpassword(userpassword);
		return u;
	}

	
}