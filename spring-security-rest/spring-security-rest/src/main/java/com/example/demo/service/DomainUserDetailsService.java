package com.example.demo.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.DomainUserDetails;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

//Implement User Detail service
@Service
public class DomainUserDetailsService implements UserDetailsService {
	
	private UserRepository userRepository;
	

	private DomainUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		 User user = this.userRepository.findByName(username).orElseThrow(() -> new UsernameNotFoundException("Invalid User"));
		
		 return new DomainUserDetails(user);
	}

}
