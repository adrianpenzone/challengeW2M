package com.challenge.challengeW2M.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.challenge.challengeW2M.domain.SuperHeroe;


public interface SuperHeroeRepository extends PagingAndSortingRepository<SuperHeroe, Long> {
	
	public List<SuperHeroe> findByNombreContains(String like);
	
}
