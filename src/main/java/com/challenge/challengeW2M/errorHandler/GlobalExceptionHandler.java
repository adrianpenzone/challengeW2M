package com.challenge.challengeW2M.errorHandler;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = HeroeNotfoundException.class)
	   public ResponseEntity<Object> exception(HeroeNotfoundException exception) {
	      return new ResponseEntity<>("Heroe no encontrado", HttpStatus.NOT_FOUND);
	   }

}
