package br.com.fiap.gsJava.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.gsJava.dtos.local.LocalDTO;
import br.com.fiap.gsJava.entities.Local;
import br.com.fiap.gsJava.exceptions.EntityNotFoundException;
import br.com.fiap.gsJava.repositories.LocalRepository;

@Service
public class LocalService {

	@Autowired
	private LocalRepository localRepository;

	public List<LocalDTO> findAll() {
		List<Local> entities = localRepository.findAll();
		List<LocalDTO> dtos = new ArrayList<>();
		
		for (Local entity : entities) {
			LocalDTO dto = new LocalDTO(entity);
			dtos.add(dto);
		}
		
		return dtos;
	}

	
	public LocalDTO findById(Long id) {
		Optional<Local> optional = localRepository.findById(id);	
		
		if (optional.isEmpty()) { 
			throw new EntityNotFoundException("Local não encontrado");
		}
				
		LocalDTO dto = new LocalDTO(optional.get());
		
		return dto;
	
		
	}

	public LocalDTO save(LocalDTO localDTO) {	
		Local entity = new Local(localDTO);
		Local entitySave = localRepository.save(entity);
		
		LocalDTO dto = new LocalDTO(entitySave);
		
		return dto;
	}

	
	public LocalDTO update(Long id, LocalDTO localDTO) {
		Optional<Local> optional = localRepository.findById(id);

		if (optional.isEmpty()) {
			throw new EntityNotFoundException("Local não encontrado");
		}

		Local localExistente = optional.get();	
		localExistente.setRua(localDTO.getRua());
		localExistente.setNumero(localDTO.getNumero());
		localExistente.setCidade(localDTO.getCidade());
		localExistente.setEstado(localDTO.getEstado());
		localExistente.setEvento(localDTO.getEvento());
		
		Local entity = localRepository.save(localExistente);
		LocalDTO dto = new LocalDTO(entity);
		
		return dto;
		
	}

	
	public LocalDTO deleteById(Long id) {
		Local entity = localRepository.findById(id).orElseThrow(
					() -> new EntityNotFoundException("Local não encontrado"));
		
		localRepository.deleteById(id);
		
		return new LocalDTO(entity);
	}
}
