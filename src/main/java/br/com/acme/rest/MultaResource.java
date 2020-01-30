package br.com.acme.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.acme.domain.Condominio;
import br.com.acme.domain.Multa;
import br.com.acme.domain.Unidade;
import br.com.acme.service.CondominioService;
import br.com.acme.service.MultaService;
import br.com.acme.service.UnidadeService;

@RestController
@RequestMapping("/api")
public class MultaResource {

	@Autowired
	private MultaService multaService;
	
	@Autowired
	private UnidadeService unidadeService;
	
	@Autowired
	private CondominioService condominioService;
	
	
	@PostMapping("/multa/unidade/{id}/condominio/{id2}")
	public ResponseEntity<String> salvar(@RequestBody Multa multa, @PathVariable Long id, @PathVariable Long id2) {
		Optional<Unidade> unidade = unidadeService.findById(id);
		Optional<Condominio> condominio = condominioService.findById(id2);
		if(unidade.isPresent()) {
			multa.setCondominoMulta(condominio.get());
			multa.setUnidadeMulta(unidade.get());
			this.multaService.salvar(multa);
			return ResponseEntity.ok().body("Adicionado com sucesso");
		}
		return ResponseEntity.ok().body("Verifique existência de unidade ou condominio");
	}
	
	@GetMapping("/multa")
	public List<Multa> listar() {
		return multaService.listar();
	}
	
	@DeleteMapping("/multa/{id}")
	public ResponseEntity<String> deletar(@PathVariable Long id) {
		multaService.deletar(id);
		return ResponseEntity.ok().body("Multa excluída: " + id);
	}
	
	
}
