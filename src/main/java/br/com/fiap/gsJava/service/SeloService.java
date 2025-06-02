package br.com.fiap.gsJava.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.gsJava.entity.Selo;
import br.com.fiap.gsJava.exception.EntityNotFoundException;
import br.com.fiap.gsJava.repository.SeloRepository;

@Service
public class SeloService {

	@Autowired
	private SeloRepository seloRepository;

	public List<Selo> findAll() {
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

		if (optional.isEmpty()) {
			return seloRepository.findById(id).orElseThrow(
					() -> new EntityNotFoundException("Selo não encontrado"));
		}

		Selo seloExistente = optional.get();
		seloExistente.setDescricao(selo.getDescricao());
		return seloRepository.save(seloExistente);
	}

	public Selo deleteById(Long id) {

		Optional<Selo> optional = seloRepository.findById(id);

		if (optional.isEmpty()) {
			return seloRepository.findById(id).orElseThrow(
					() -> new EntityNotFoundException("Selo não encontrado"));
		}

		Selo selo = optional.get();
		seloRepository.deleteById(id);
		return selo;
	}
}
