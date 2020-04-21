package br.com.mcord.alpr.bdv;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/veiculo")
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
	
	
	
	@GetMapping("ack")
	public String hello() {
		return String.format("> ack");
	}

}
