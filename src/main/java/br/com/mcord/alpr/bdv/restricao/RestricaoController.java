package br.com.mcord.alpr.bdv.restricao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/veiculos")
public class RestricaoController {
	
	@Autowired
	RestricaoRepository restricaoRepository;
	
	@GetMapping("/{id}/restricoes")
	public ResponseEntity<Restricao> getAllRestricoes(@PathVariable("id") int cdVeiculo) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	@GetMapping("/{id}/restricoes/{idRestricoes}")
	public ResponseEntity<Restricao> getRestricaoById(@PathVariable("id") int cdVeiculo, @PathVariable("idRestricoes") int cdRestricao) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	@PostMapping("/{id}/restricoes")
	public ResponseEntity<Restricao> createRestricao(@PathVariable("id") int cdVeiculo, @RequestBody Restricao restricao) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

}
