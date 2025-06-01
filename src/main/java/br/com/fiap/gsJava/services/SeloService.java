package br.com.fiap.gsJava.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.fiap.gsJava.entities.Selo;
import br.com.fiap.gsJava.exceptions.EntityNotFoundException;
import br.com.fiap.gsJava.repositories.SeloRepository;
import jakarta.validation.Valid;

@Service
public class SeloService {

	@Autowired
	private SeloRepository seloRepository;
	
	public List<Selo> findAll(){
		return seloRepository.findAll();
	}
	
	public Selo findById(Long id) {
		return seloRepository.findById(id).orElseThrow(
				() -> new EntityNotFoundException("Selo não encontrado"));
				
	}
	
	public Selo save(Selo selo) {
		return seloRepository.save(selo); 
	}
	
	public Selo update(Long id, Selo selo) {
		
		Optional<Selo> optional = seloRepository.findById(id);
		
		/*
		if(optional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Selo não encontrado");
		}
		*/
		Selo seloExistente = optional.get();
		
		seloExistente.setDescricao(selo.getDescricao());
		
		return seloRepository.save(seloExistente);
	}
	
	public Selo deleteById(Long id) {
		Selo selo = seloRepository.findById(id).get();
		seloRepository.deleteById(id);
		return selo;
	}
}


