package br.com.acme.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.acme.domain.*;
import br.com.acme.service.CondominioService;

@RestController
@RequestMapping("/api")
public class CondominioResource {

	@Autowired
	private CondominioService condominioService;
	
	@PostMapping("/condominio")
	public ResponseEntity<Condominio> salvar(@RequestBody Condominio condominio) {
		condominio = condominioService.salvar(condominio).get();
		return ResponseEntity.ok().body(condominio);
	}
	
	@GetMapping("/condominio")
	public ResponseEntity<List<Condominio>> listar() {
		return ResponseEntity.ok(this.condominioService.listar());
	}
	
	@DeleteMapping("/condominio/{id}")
	public ResponseEntity<String> deletar(@PathVariable Long id) {
		condominioService.deletar(id);
		return ResponseEntity.ok().body("Condominio excluída: " + id);
	}
	
	
}
