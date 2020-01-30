package br.com.acme.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.acme.domain.Unidade;
import br.com.acme.service.UnidadeService;

@RestController
@RequestMapping("/api")
public class UnidadeResource {

	@Autowired
	private UnidadeService unidadeService;
	
	@PostMapping("/unidade")
	public ResponseEntity<Unidade> salvar(@RequestBody Unidade unidade) {
		unidade = unidadeService.salvar(unidade).get();
		return ResponseEntity.ok().body(unidade);
	}
	
	@GetMapping("/unidade")
	public ResponseEntity<List<Unidade>> listar() {
		return ResponseEntity.ok(this.unidadeService.listar());
	}
	
	@DeleteMapping("/unidade/{id}")
	public ResponseEntity<String> deletar(@PathVariable Long id) {
		unidadeService.deletar(id);
		return ResponseEntity.ok().body("Unidade excluída: " + id);
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/unidadesemmulta")
	public ResponseEntity<Object[]> unidadeSemMulta() {
		return ResponseEntity.ok(this.unidadeService.unidadeSemMulta());
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/unidadecommulta")
	public ResponseEntity<Object[]> unidadeComMulta() {
		return ResponseEntity.ok(this.unidadeService.unidadeComMulta());
	}
	
}