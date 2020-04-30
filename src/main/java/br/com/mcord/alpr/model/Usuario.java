package br.com.mcord.alpr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "seg_usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = -1049756479899668476L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cd_usuario")
	private Integer cdUsuario;
	
	@Column(name = "nm_login")
	private String nmLogin;
	
	@Column(name = "nm_senha")
	private String nmSenha;
	
	private String token;
	
	public Usuario(Integer cdUsuario, String nmLogin, String nmSenha, String token) {
		super();
		this.cdUsuario = cdUsuario;
		this.nmLogin = nmLogin;
		this.nmSenha = nmSenha;
		this.token = token;
	}

	public Usuario(Integer cdUsuario, String nmLogin, String nmSenha) {
		super();
		this.cdUsuario = cdUsuario;
		this.nmLogin = nmLogin;
		this.nmSenha = nmSenha;
	}

	public Usuario() {
		super();
	}

	public Integer getCdUsuario() {
		return cdUsuario;
	}

	public void setCdUsuario(Integer cdUsuario) {
		this.cdUsuario = cdUsuario;
	}

	public String getNmLogin() {
		return nmLogin;
	}

	public void setNmLogin(String nmLogin) {
		this.nmLogin = nmLogin;
	}

	public String getNmSenha() {
		return nmSenha;
	}

	public void setNmSenha(String nmSenha) {
		this.nmSenha = nmSenha;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "Usuario [cdUsuario=" + cdUsuario + ", nmLogin=" + nmLogin + ", nmSenha=" + nmSenha + ", token=" + token + "]";
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return new Usuario(this.getCdUsuario(), this.getNmLogin(), this.getNmSenha(), this.getToken());
	}
	
}
