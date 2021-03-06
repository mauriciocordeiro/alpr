package br.com.mcord.alpr.util;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWT {
	
	private static JWT instance = new JWT();
	
	private JWT() {}	
	
	public static JWT getInstance() {
        return instance;
    }
		
	public static String generateToken(String id, String subject, String secret, Long exp) {
		
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		exp = 1000 * 60 * 60 * exp;
		
		return Jwts
				.builder()
				.setId(id)
				.setSubject(subject)
				.claim("authorities",
						grantedAuthorities
								.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + exp))
				.signWith(SignatureAlgorithm.HS512, secret.getBytes()).compact();
	}
}
