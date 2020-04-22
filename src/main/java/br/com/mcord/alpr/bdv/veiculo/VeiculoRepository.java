	package br.com.mcord.alpr.bdv.veiculo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {

	List<Veiculo> findByNrPlaca(String nrPlaca);
	
}
