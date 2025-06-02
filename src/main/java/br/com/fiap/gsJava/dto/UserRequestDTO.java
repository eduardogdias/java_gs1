package br.com.fiap.gsJava.dto;

import br.com.fiap.gsJava.entities.Usuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDTO extends UsuarioDTO {
	
	private int seloId;

	public UserRequestDTO(Usuario usuario, int seloId) {
		super(usuario);
		this.seloId = seloId;
	}
	
	
}
