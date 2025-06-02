package br.com.fiap.gsJava.dto;

import br.com.fiap.gsJava.entities.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsuarioDTO {

	private Long id;
	private String nome;
	private String email;
	//private String senha;
	private String cidade;
	private String estado;
	private String telefone;

	private String selo;
	
	public UsuarioDTO(Usuario usuario) {
		id = usuario.getId();
		nome = usuario.getNome();
		email = usuario.getEmail();
		cidade = usuario.getCidade();
		estado = usuario.getEstado();
		telefone = usuario.getTelefone();
		selo = usuario.getSelo().getDescricao();
		
	}

}