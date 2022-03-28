package com.filipe.ServiceInfo.controllers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.filipe.ServiceInfo.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ControllerExceptionsHandler {

	//Tratamento de Cliente nao encontrado
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException e){
		StandardError error = new StandardError(
				System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), e.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	// Tratamento de coluna telefone duplicada em Clientes
	@ExceptionHandler(ViolationException.class)
	public ResponseEntity<StandardError> objectNotFoundException(ViolationException e){
		StandardError error = new StandardError(
				System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), e.getMessage());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
}
