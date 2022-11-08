package com.vvsolution.login.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.vvsolution.login.model.Users;
import com.vvsolution.login.repository.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Users user =userRepository.getUserByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException("User is not Found kindly try with another username");
			
		}
		return new MyUserDetails(user);
	}

}
