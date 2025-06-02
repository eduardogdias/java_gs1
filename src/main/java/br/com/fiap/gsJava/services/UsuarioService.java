package br.com.fiap.gsJava.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.gsJava.dto.UsuarioDTO;
import br.com.fiap.gsJava.entities.Usuario;
import br.com.fiap.gsJava.exceptions.EntityNotFoundException;
import br.com.fiap.gsJava.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository UsuarioRepository;

	public List<UsuarioDTO> findAll() {
		List<Usuario> entities = new ArrayList<>();
		entities = UsuarioRepository.findAll();
		
		List<UsuarioDTO> dtos = new ArrayList<>();
		
		for (Usuario usuario : entities) {  //convertendo cada Entity em um DTO
			UsuarioDTO dto = new UsuarioDTO(usuario);
			dtos.add(dto);
		}
		
		return dtos; 
	}

	public UsuarioDTO findById(Long id) {
		Usuario entity = UsuarioRepository.findById(id).orElseThrow(
				() -> new EntityNotFoundException("Usuário não encontrado"));
		UsuarioDTO dto = new UsuarioDTO(entity);
		return dto;

	}

	public Usuario save(Usuario Usuario) {
		return UsuarioRepository.save(Usuario);
	}

	public Usuario update(Long id, Usuario Usuario) {

		Optional<Usuario> optional = UsuarioRepository.findById(id);

		if (optional.isEmpty()) {
			return UsuarioRepository.findById(id).orElseThrow(
					() -> new EntityNotFoundException("Usuario não encontrado"));
		}

		Usuario UsuarioExistente = optional.get();
		UsuarioExistente.setNome(Usuario.getNome());
		UsuarioExistente.setEmail(Usuario.getEmail());
		UsuarioExistente.setSenha(Usuario.getSenha());
		UsuarioExistente.setCidade(Usuario.getCidade());
		UsuarioExistente.setEstado(Usuario.getEstado());
		UsuarioExistente.setTelefone(Usuario.getTelefone());
		UsuarioExistente.setSelo(Usuario.getSelo());
		return UsuarioRepository.save(UsuarioExistente);
	}

	public Usuario deleteById(Long id) {

		Optional<Usuario> optional = UsuarioRepository.findById(id);

		if (optional.isEmpty()) {
			return UsuarioRepository.findById(id).orElseThrow(
					() -> new EntityNotFoundException("Usuario não encontrado"));
		}

		Usuario Usuario = optional.get();
		UsuarioRepository.deleteById(id);
		return Usuario;
	}
}
