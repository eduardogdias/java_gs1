package br.com.fiap.gsJava.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerExceptionHandler { //vai interceptar todas as exception do controller automaticamente

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<MessageException> entityNotFound(EntityNotFoundException e){
		MessageException msg = new MessageException();
		msg.setMessage(e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex) {
        // Pegando o primeiro erro de validação
        FieldError firstError = ex.getBindingResult().getFieldErrors().get(0);
        String errorMessage = firstError.getDefaultMessage();

        // Criando a resposta personalizada
        Map<String, String> response = new HashMap<>();
        response.put("message", errorMessage);

        return ResponseEntity.badRequest().body(response);
    }
	
	@ExceptionHandler(SeloNotFoundException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<Map<String, String>> handleSeloNotFound(SeloNotFoundException ex) {
	    Map<String, String> response = new HashMap<>();
	    response.put("message", ex.getMessage());
	    return ResponseEntity.badRequest().body(response);
	}
}
