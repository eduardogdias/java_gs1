package br.com.fiap.gsJava.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler { //vai interceptar todas as exception do controller automaticamente

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<MessageException> entityNotFound(EntityNotFoundException e){
		MessageException msg = new MessageException();
		msg.setMessage(e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
	}
}
