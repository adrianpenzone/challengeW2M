package com.challenge.challengeW2M.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.challenge.challengeW2M.annotation.TrackExecutionTime;
import com.challenge.challengeW2M.dao.SuperHeroeDao;
import com.challenge.challengeW2M.model.SuperHeroe;

@Service
public class SuperHeroeService {
	
	@Autowired
	private SuperHeroeDao superHeroeDao;

	@Transactional(readOnly = true)
	public Page<SuperHeroe> findAll(Pageable pageable) {
		return superHeroeDao.findAll(pageable);
	}
	
	@Transactional(readOnly = true)
	public Optional<SuperHeroe> findById(Long id){
		return superHeroeDao.findById(id);
	}
	
	@Transactional(readOnly = true)
	public List<SuperHeroe> findByNombreLike(String like){
		return superHeroeDao.findByNombreContains(like);
	}
	
	@Transactional
	public SuperHeroe modificar(SuperHeroe superHeroe) {
		return superHeroeDao.save(superHeroe);
	}
	
	@Transactional
	public void deleteById(Long id) {
		superHeroeDao.deleteById(id);
	}

}
