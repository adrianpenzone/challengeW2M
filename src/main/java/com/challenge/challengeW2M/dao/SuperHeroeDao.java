package com.challenge.challengeW2M.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.challenge.challengeW2M.model.SuperHeroe;


public interface SuperHeroeDao extends PagingAndSortingRepository<SuperHeroe, Long> {

}
