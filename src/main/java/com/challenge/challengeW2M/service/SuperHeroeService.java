package com.challenge.challengeW2M.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.challenge.challengeW2M.dao.SuperHeroeDao;
import com.challenge.challengeW2M.model.SuperHeroe;

@Service
public class SuperHeroeService {
	
	@Autowired
	private SuperHeroeDao superHeroeDao;
	
	
	@Transactional(readOnly = true)
	public List<SuperHeroe> findAll() {
		return (List<SuperHeroe>) superHeroeDao.findAll();
	}
	
	@Transactional(readOnly = true)
	public Optional<SuperHeroe> findById(Long id){
		return superHeroeDao.findById(id);
	}
	

}
