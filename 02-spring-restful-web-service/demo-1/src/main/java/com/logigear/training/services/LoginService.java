package com.logigear.training.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Service;

import com.logigear.training.models.AuthenticateRequestDTO;
import com.logigear.training.models.UsersDTO;

@Service
public class LoginService {
	public List<UsersDTO> USERS;
	
	//NgOnInit
	//useEffect
	@PostConstruct
	public void initData() {
		USERS = new ArrayList<>();
		USERS.add(new UsersDTO("user", "user", "User", "User"));
		USERS.add(new UsersDTO("admin", "admin", "Admin", "Administrator"));
	}
	
	//
	//@PreDestroy
	//NgOnDestroy
	//componentWillUnmount

	public UsersDTO authenticate(AuthenticateRequestDTO dto) {
		UsersDTO user = null;
		System.out.println(dto.getUsername() + " " + dto.getPassword());

		for (int i = 0; i < USERS.size(); i++) {

			if (USERS.get(i).getUsername() == dto.getUsername()) {
				if (USERS.get(i).getPassword() == dto.getPassword()) {
					user = USERS.get(i);
				}
			}
		}
		return user;

	}

	public List<UsersDTO> findAll() {
		return USERS;
	}

	public UsersDTO findById(String username) {
		UsersDTO dto = null;
		for (int i = 0; i < USERS.size(); i++) {
			if (USERS.get(i).getUsername() == username) {
				dto = USERS.get(i);
			}
		}
		return dto;
	}

	public UsersDTO addNewUser(UsersDTO user) {
		USERS.add(user);
		return user;
	}

	public void removeAUser(String username) {
		for (int i=0; i < USERS.size(); i++) {
			if (USERS.get(i).getUsername() == username) {
				USERS.remove(i);
			}
		}
	}

	public void updateAUser(String username, UsersDTO dto) {
		// TODO Auto-generated method stub
		
	}
}
