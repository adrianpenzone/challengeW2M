package com.challenge.challengeW2M.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.challenge.challengeW2M.model.SuperHeroe;


public interface SuperHeroeDao extends PagingAndSortingRepository<SuperHeroe, Long> {
	
	public List<SuperHeroe> findByNombreContains(String like);
	
}
