package br.com.mcord.alpr.bdv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mcord.alpr.bdv.model.Restricao;

public interface RestricaoRepository extends JpaRepository<Restricao, Integer> {
//	@Query("SELECT A.* FROM bdv_restricao A WHERE A.cd_veiculo = :id")
//	List<Restricao> findAllRestricoesByCdVeiculo(@Param("id") int cdVeiculo);
	
	List<Restricao> findAllByCdVeiculo(int cdVeiculo);

}
