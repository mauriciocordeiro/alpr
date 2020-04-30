package br.com.mcord.alpr.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mcord.alpr.model.Restricao;
import br.com.mcord.alpr.model.Veiculo;
import br.com.mcord.alpr.repository.RestricaoRepository;
import br.com.mcord.alpr.repository.VeiculoRepository;

@RestController
@RequestMapping("/api/veiculos")
public class RestricaoController {
	
	@Autowired
	RestricaoRepository restricaoRepository;
	
	@Autowired
	VeiculoRepository veiculoRepository;
	
	@GetMapping("/{id}/restricoes")
	public ResponseEntity<List<Restricao>> getAllRestricoes(@PathVariable("id") int cdVeiculo) {
		try {
			Optional<Veiculo> veiculoData = veiculoRepository.findById(cdVeiculo);
			
			if(veiculoData.isPresent()) {
				List<Restricao> restricoes = new ArrayList<Restricao>();
				restricaoRepository.findAllByCdVeiculo(cdVeiculo).forEach(restricoes::add);
				
				if(restricoes.isEmpty())
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				
				return new ResponseEntity<>(restricoes, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}/restricoes/{idRestricoes}")
	public ResponseEntity<Restricao> getRestricaoById(@PathVariable("id") int cdVeiculo, @PathVariable("idRestricoes") int cdRestricao) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	@PostMapping("/{id}/restricoes")
	public ResponseEntity<Restricao> createRestricao(@PathVariable("id") int cdVeiculo, @RequestBody Restricao restricao) {
		try {
			
			Veiculo veiculo = veiculoRepository.getOne(cdVeiculo);
			if(veiculo == null)
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
			restricao.setVeiculo(veiculo);
			
			Restricao _restricao = restricaoRepository.save(restricao);
			
			return new ResponseEntity<>(_restricao, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
