package br.com.fiap.gsJava.entities;

import br.com.fiap.gsJava.dtos.local.LocalDTO;
import br.com.fiap.gsJava.enums.LocalEventoEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_localDTO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Local {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String rua;
	private Long numero;
	private String cidade;
	private String estado;
	
	@Enumerated(EnumType.STRING)
	private LocalEventoEnum evento;
	private boolean status;
	
	public Local(LocalDTO localDTO) {
		this.id = localDTO.getId();
		this.rua = localDTO.getRua();
		this.numero = localDTO.getNumero();
		this.cidade = localDTO.getCidade();
		this.estado = localDTO.getEstado();
		this.evento = localDTO.getEvento();
		this.status = true;
	}

	
}
