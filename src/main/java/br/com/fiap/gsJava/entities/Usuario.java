package br.com.fiap.gsJava.entities;

import br.com.fiap.gsJava.dto.UsuarioRequestDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_usuario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String senha;
	private String cidade;
	private String estado;
	private String telefone;

	@ManyToOne
	@JoinColumn(name = "selo_id")
	private Selo selo;

	
	public Usuario(UsuarioRequestDTO usuarioRequestDTO) {
		this.nome = usuarioRequestDTO.getNome();
		this.email = usuarioRequestDTO.getEmail();
		this.senha = usuarioRequestDTO.getSenha();
		this.cidade = usuarioRequestDTO.getCidade();
		this.estado = usuarioRequestDTO.getEstado();
		this.telefone = usuarioRequestDTO.getTelefone();
		
		/*Selo selo = new Selo(usuarioRequestDTO.getSeloId()); //cria um selo passando o ID
		this.selo = selo;*/
		
	

	}
	
	
	

}
