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

import br.com.acme.domain.Aviso;
import br.com.acme.domain.Condominio;
import br.com.acme.service.AvisoService;
import br.com.acme.service.CondominioService;

@RestController
@RequestMapping("/api")
public class AvisoResource {

	@Autowired
	private AvisoService avisoService;
	
	@Autowired
	private CondominioService condominioService;
	
	@PostMapping("/aviso/condominio/{id}")
	public ResponseEntity<String> salvar(@RequestBody Aviso aviso, @PathVariable Long id) {
		Optional<Condominio> condominio = condominioService.findById(id);
		if(condominio.isPresent()) {
			aviso.setCondominoAvisos(condominio.get());
			aviso = avisoService.salvar(aviso).get();
			return ResponseEntity.ok().body("Enviado");			
		}
		return ResponseEntity.ok().body("Não Enviado");
	}
	
	@GetMapping("/aviso")
	public ResponseEntity<List<Aviso>> listar() {
		return ResponseEntity.ok(this.avisoService.listar());
	}
	
	@DeleteMapping("/aviso/{id}")
	public ResponseEntity<String> deletar(@PathVariable Long id) {
		avisoService.deletar(id);
		return ResponseEntity.ok().body("Aviso excluída: " + id);
	}
	
	
}
