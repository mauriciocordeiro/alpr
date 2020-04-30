package br.com.mcord.alpr.model;

import java.io.Serializable;

public class Credentials implements Serializable {
	
	private static final long serialVersionUID = -110779148856556794L;
	
	private String user;
	private String password;
	
	public Credentials(String user, String password) {
		super();
		this.user = user;
		this.password = password;
	}

	public Credentials() {
		super();
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
