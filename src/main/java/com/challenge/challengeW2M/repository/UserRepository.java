package com.challenge.challengeW2M.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.challenge.challengeW2M.domain.User;

@Component
public interface UserRepository extends JpaRepository<User, Long> {

	User findByName(String name);

}
