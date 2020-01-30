package br.com.acme.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.acme.domain.Multa;
import br.com.acme.repository.MultaRepository;

@Service
public class MultaService {

	@Autowired
	private MultaRepository multaRepository;
	
	@Transactional(readOnly=true)
	public List<Multa> listar() {
		return this.multaRepository.findAll();
	}
	
	@Transactional
	public Optional<Multa> salvar(Multa multa) {
		return Optional.of(multaRepository.save(multa));
	}
	
	@Transactional
	public void deletar(Long id) {
		this.multaRepository.deleteById(id);
	}
	
	@Transactional(readOnly=true)
	public Optional<Multa> findById(Long id) {
		return this.multaRepository.findById(id);
	}
	
	
}
