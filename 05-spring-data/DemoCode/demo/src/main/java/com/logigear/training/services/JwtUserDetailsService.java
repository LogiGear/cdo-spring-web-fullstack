package com.logigear.training.services;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.logigear.training.entities.Employee;
import com.logigear.training.repositories.EmployeeRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	private final EmployeeRepository repository;
	
	@Autowired
	public JwtUserDetailsService(EmployeeRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Employee> emp = this.repository.findById(username);
		if (emp.isEmpty()) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(emp.get().getUsername(), emp.get().getPassword(),
				Arrays.asList(new SimpleGrantedAuthority(emp.get().getRole())));
	}
}
