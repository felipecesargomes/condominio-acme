package br.com.acme.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.acme.domain.Aviso;
import br.com.acme.repository.AvisoRepository;

@Service
public class AvisoService {

	@Autowired
	private AvisoRepository avisoRepository;
	
	@Transactional(readOnly=true)
	public List<Aviso> listar() {
		return this.avisoRepository.findAll();
	}
	
	@Transactional
	public Optional<Aviso> salvar(Aviso aviso) {
		return Optional.of(avisoRepository.save(aviso));
	}
	
	@Transactional
	public void deletar(Long id) {
		this.avisoRepository.deleteById(id);
	}
	
	@Transactional(readOnly=true)
	public Optional<Aviso> getById(Long id) {
		return this.avisoRepository.findById(id);
		
	}
	
}
