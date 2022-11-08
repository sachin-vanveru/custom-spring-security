package com.vvsolution.login.config;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.vvsolution.login.model.Users;
import com.vvsolution.login.repository.UserRepository;

public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Resource
	UserDetailsService userDetailsService;
	
	@Autowired
	UserRepository userRepository;

	UserDetails isValidUser(String username, String password) {
			System.out.println("inside isvalidUser method");
			UserDetailsServiceImpl userService =new UserDetailsServiceImpl();
			Users user =userRepository.getUserByUsername(username);
			MyUserDetails userDetails=new MyUserDetails(user);
			if(user==null) {
				userDetails=null;
			}
			return userDetails;
		
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		System.out.println("=====>inside Custom Methods");
		String userName = authentication.getName();
		String userPassword = authentication.getCredentials().toString();
		UserDetails userDetails = isValidUser(userName, userPassword);
		if (userDetails != null) {
			Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
			Authentication auth = new UsernamePasswordAuthenticationToken(userName, userPassword, authorities);
			
			return auth;
		} else {
			throw new BadCredentialsException("Incorrect user credentials !!");
		}
//		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
