package br.com.mcord.alpr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mcord.alpr.model.Credentials;
import br.com.mcord.alpr.model.Usuario;
import br.com.mcord.alpr.repository.UsuarioRepository;
import br.com.mcord.alpr.util.JWT;

@RestController
@RequestMapping("/api")
public class CredentialsController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Value("${br.com.mcord.alpr.jwt.secret}")
	private String jwtSecret;
	
	@Value("${br.com.mcord.alpr.jwt.exp}")
	private long jwtExp;
	
	@PostMapping("/login")
	public ResponseEntity<Usuario> login(@RequestBody Credentials credentials) {
		try {			
			List<Usuario> usuarios = usuarioRepository.findByNmLogin(credentials.getUser());
			if(usuarios.isEmpty())
				return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
			
			Usuario usuario = usuarios.get(0);
			
			if(!usuario.getNmSenha().equals(credentials.getPassword()))
				return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
			
			usuario.setNmSenha(null);
			usuario.setToken(JWT.generateToken(Integer.toString(usuario.getCdUsuario()), usuario.getNmLogin(), jwtSecret, jwtExp));
			
			return new ResponseEntity<>(usuario, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace(System.err);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
