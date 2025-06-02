package br.com.fiap.gsJava.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.gsJava.entity.Publicacao;
import br.com.fiap.gsJava.entity.Usuario;
import br.com.fiap.gsJava.exception.EntityNotFoundException;
import br.com.fiap.gsJava.repository.PublicacaoRepository;
import br.com.fiap.gsJava.repository.UsuarioRepository;

@Service
public class PublicacaoService {

	@Autowired
	private PublicacaoRepository publicacaoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Publicacao> findAll() {
		return publicacaoRepository.findAll();
	}

	public Publicacao findById(Long id) {
		return publicacaoRepository.findById(id).orElseThrow(
				() -> new EntityNotFoundException("Publicação não encontrada"));

	}

	
	
	public Publicacao save(Publicacao publicacao) {

	    // Carrega o usuario do banco
		Optional<Usuario> optionalUsuario = usuarioRepository.findById(publicacao.getUsuario().getId());
		if (optionalUsuario.isEmpty()) {
			throw new EntityNotFoundException("Usuário de ID " + publicacao.getUsuario().getId() + " não encontrado");
		}

	    
	    publicacao.setUsuario(optionalUsuario.get()); // seta o usuario carregado

	    Publicacao entity = publicacaoRepository.save(publicacao);

	    return findById(entity.getId());
	}
	
	
	/*
	public Publicacao update(Long id, Publicacao Publicacao) {

		Optional<Publicacao> optional = publicacaoRepository.findById(id);

		if (optional.isEmpty()) {
			return publicacaoRepository.findById(id).orElseThrow(
					() -> new EntityNotFoundException("Publicação não encontrada"));
		}

		Publicacao PublicacaoExistente = optional.get();
		PublicacaoExistente.setDescricao(Publicacao.getDescricao());
		return publicacaoRepository.save(PublicacaoExistente);
	}

*/
	
	public Publicacao deleteById(Long id) {

		Optional<Publicacao> optional = publicacaoRepository.findById(id);

		if (optional.isEmpty()) {
			return publicacaoRepository.findById(id).orElseThrow(
					() -> new EntityNotFoundException("Publicação não encontrad"));
		}

		Publicacao Publicacao = optional.get();
		publicacaoRepository.deleteById(id);
		return Publicacao;
	}
}
