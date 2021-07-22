package com.challenge.challengeW2M.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.challenge.challengeW2M.domain.User;
import com.challenge.challengeW2M.mapper.UserDetailsMapper;
import com.challenge.challengeW2M.repository.UserRepository;


@Service("userDetailsService")
public class UserServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		final User retrievedUser = userRepository.findByName(userName);
		if (retrievedUser == null) {
			throw new UsernameNotFoundException("Invalid username or password");
		}

		return UserDetailsMapper.build(retrievedUser);
	}

	
}
