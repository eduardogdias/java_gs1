package br.com.fiap.gsJava.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageException {
	
	private String message;
	
	public MessageException() { //vai ser mostrado {"message": "texto..."}
		
	}
	
	
}
