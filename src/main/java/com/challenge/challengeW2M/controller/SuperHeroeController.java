package com.challenge.challengeW2M.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.challengeW2M.model.SuperHeroe;
import com.challenge.challengeW2M.service.SuperHeroeService;



@RestController
@RequestMapping("/superHeroes")
public class SuperHeroeController {

	@Autowired
	private SuperHeroeService superHeroeService;
	
	@GetMapping
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok().body(superHeroeService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id){
		Optional<SuperHeroe> o = superHeroeService.findById(id);
		if (o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
	}
}
