package com.nt.Services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.Binding.RegisterBinding;
import com.nt.Entity.User;
import com.nt.Repository.UserRepo;

import jakarta.servlet.http.HttpSession;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public boolean register(RegisterBinding binding) {

		User user = new User();
		BeanUtils.copyProperties(binding, user);
		userRepo.save(user);
		return true;
	}
	
	@Override
	public boolean login(RegisterBinding binding) {
		
		User user=userRepo.findByEmailAndPassword(binding.getEmail(),binding.getPassword());
		if(user==null) {
			return false;
			
		}
		
		session.setAttribute("userId", user.getUserId());
		return true;
	}
}
