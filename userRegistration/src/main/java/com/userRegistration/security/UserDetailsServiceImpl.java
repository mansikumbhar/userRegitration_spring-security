package com.userRegistration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.userRegistration.Entity.User;
import com.userRegistration.Repository.UserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user=userRepository.getUserByUsername(username);  //calling method from repository layer
		
		if(user==null){
			throw new UsernameNotFoundException("could not find user");  //user defined exception
		}
		return new MyUserDetails(user); //passing the user name
	}
}
