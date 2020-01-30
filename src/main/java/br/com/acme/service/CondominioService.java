package br.com.acme.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.acme.domain.Condominio;
import br.com.acme.repository.CondominioRepository;

@Service
public class CondominioService {

	@Autowired
	private CondominioRepository condominioRepository;

	@Transactional(readOnly=true)
	public List<Condominio> listar() {
		return this.condominioRepository.findAll();
	}

	@Transactional
	public Optional<Condominio> salvar(Condominio condominio) {
		return Optional.of(condominioRepository.save(condominio));
	}

	@Transactional
	public void deletar(Long id) {
		this.condominioRepository.deleteById(id);
	}

	@Transactional(readOnly=true)
	public Optional<Condominio> findById(Long id) {
		return this.condominioRepository.findById(id);
	}

}
