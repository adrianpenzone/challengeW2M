package com.challenge.challengeW2M.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.challengeW2M.annotation.TrackExecutionTime;
import com.challenge.challengeW2M.model.SuperHeroe;
import com.challenge.challengeW2M.service.SuperHeroeService;



@RestController
@RequestMapping("/superHeroes")
public class SuperHeroeController {

	@Autowired
	private SuperHeroeService superHeroeService;
	
	@TrackExecutionTime
	@GetMapping
	public ResponseEntity<?> listar(Pageable pageable) {
		return ResponseEntity.ok().body(superHeroeService.findAll(pageable));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id){
		Optional<SuperHeroe> o = superHeroeService.findById(id);
		if (o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
	}
	
	@GetMapping("/consultar/{like}")
	public ResponseEntity<?> consultar(@PathVariable String like){
		return ResponseEntity.ok().body(superHeroeService.findByNombreLike(like));
	}
	
	@PutMapping
	public ResponseEntity<SuperHeroe> modificar (@RequestBody SuperHeroe superHeroe){
		return ResponseEntity.ok(superHeroeService.modificar(superHeroe));
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id){
		superHeroeService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}
