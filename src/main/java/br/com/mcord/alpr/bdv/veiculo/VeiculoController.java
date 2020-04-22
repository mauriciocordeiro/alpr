package br.com.mcord.alpr.bdv.veiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.mcord.alpr.bdv.restricao.Restricao;

@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {
	
	@Autowired
	VeiculoRepository veiculoRepository;
	
	@GetMapping("")
	public ResponseEntity<List<Veiculo>> getAllVeiculos(@RequestParam(name = "placa", required = false) String nrPlaca) {
		try {
			List<Veiculo> veiculos = new ArrayList<Veiculo>();
			
			if(nrPlaca == null)
				veiculoRepository.findAll().forEach(veiculos::add);
			else
				veiculoRepository.findByNrPlaca(nrPlaca).forEach(veiculos::add);
			
			if(veiculos.isEmpty())
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
			return new ResponseEntity<>(veiculos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Veiculo> getVeiculosById(@PathVariable("id") int cdVeiculo) {
		try {
			
			Optional<Veiculo> veiculoData = veiculoRepository.findById(cdVeiculo);
			
			if(veiculoData.isPresent()) {
				return new ResponseEntity<>(veiculoData.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@PostMapping("")
	public ResponseEntity<Veiculo> createVeiculo(@RequestBody Veiculo veiculo) {
		try {
			Veiculo _veiculo = veiculoRepository.save((Veiculo)veiculo.clone());
			
			return new ResponseEntity<>(_veiculo, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Veiculo> updateVeiculo(@PathVariable("id") int cdVeiculo, @RequestBody Veiculo veiculo) {
		try {
			Optional<Veiculo> veiculoData = veiculoRepository.findById(cdVeiculo);
			
			if(veiculoData.isPresent()) {
				return new ResponseEntity<>(veiculoRepository.save((Veiculo)veiculo.clone()), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@DeleteMapping("")
	public ResponseEntity<HttpStatus> deleteAllVeiculos() {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteVeiculo(@PathVariable("id") int cdVeiculo) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

}
