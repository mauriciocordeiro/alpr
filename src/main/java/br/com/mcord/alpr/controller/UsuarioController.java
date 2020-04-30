package br.com.mcord.alpr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mcord.alpr.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
		
	@Autowired
	UsuarioRepository usuarioRepository;
	
	
	

}
