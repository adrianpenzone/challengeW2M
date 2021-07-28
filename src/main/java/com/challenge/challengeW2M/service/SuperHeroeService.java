package com.challenge.challengeW2M.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.challenge.challengeW2M.domain.SuperHeroe;
import com.challenge.challengeW2M.errorHandler.HeroeNotfoundException;
import com.challenge.challengeW2M.repository.SuperHeroeRepository;

@Service
public class SuperHeroeService {
	
	@Autowired
	private SuperHeroeRepository superHeroeRepository;

	@Transactional(readOnly = true)
	public Page<SuperHeroe> findAll(Pageable pageable) {
		return superHeroeRepository.findAll(pageable);
	}
	
	@Transactional(readOnly = true)
	public SuperHeroe findById(Long id){
		Optional<SuperHeroe> o = superHeroeRepository.findById(id);		
		return o.orElseThrow(() -> new HeroeNotfoundException());
	}
	
	@Transactional(readOnly = true)
	public List<SuperHeroe> findByNombreLike(String like){
		return superHeroeRepository.findByNombreContains(like);
	}
	
	@Transactional
	public SuperHeroe modificar(SuperHeroe superHeroe) {
		return superHeroeRepository.save(superHeroe);
	}
	
	@Transactional
	public void deleteById(Long id) {
		superHeroeRepository.deleteById(id);
	}

}
