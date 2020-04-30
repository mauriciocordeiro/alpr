package br.com.mcord.alpr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mcord.alpr.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	List<Usuario> findByNmLogin(String nmLogin);

}
