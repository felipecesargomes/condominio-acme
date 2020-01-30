package br.com.acme.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.acme.domain.Unidade;
import br.com.acme.repository.UnidadeRepository;

@Service
public class UnidadeService {

	@Autowired
	private UnidadeRepository unidadeRepository;

	@Transactional(readOnly=true)
	public List<Unidade> listar() {
		return this.unidadeRepository.findAll();
	}

	@Transactional
	public Optional<Unidade> salvar(Unidade unidade) {
		return Optional.of(unidadeRepository.save(unidade));
	}
	
	@Transactional
	public void deletar(Long id) {
		this.unidadeRepository.deleteById(id);
	}

	@Transactional(readOnly=true)
	public Optional<Unidade> findById(Long id) {
		return this.unidadeRepository.findById(id);
	}
	
	@Transactional(readOnly=true)
	public Object[] unidadeSemMulta() {
		return this.unidadeRepository.unidadeSemMulta();
	}
	
	@Transactional(readOnly=true)
	public Object[] unidadeComMulta() {
		return this.unidadeRepository.unidadeComMulta();
	}
	
}
