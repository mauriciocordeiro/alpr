	package br.com.mcord.alpr.bdv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mcord.alpr.bdv.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {

	List<Veiculo> findByNrPlaca(String nrPlaca);
	
}
