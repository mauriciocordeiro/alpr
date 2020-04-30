package br.com.mcord.alpr.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "bdv_restricao")
public class Restricao implements Serializable {

	private static final long serialVersionUID = 2656777061443227613L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cd_restricao")
	private int cdRestricao;
	
	@Column(name = "txt_restricao")
	private String txtRestricao;
	
	@Column(name = "tp_restricao")
	private int tpRestricao;
	
	@Column(name = "st_restricao")
	private int stRestricao;
	
	@Column(name = "dt_restricao")
	private LocalDate dtRestricao;
	
	@Column(name = "cd_veiculo", insertable = false, updatable = false)
	private int cdVeiculo;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "cd_veiculo")
	private Veiculo veiculo;
	
	public Restricao() {
		super();
	}

	public Restricao(int cdRestricao, String txtRestricao, int tpRestricao, int stRestricao, LocalDate dtRestricao, Veiculo veiculo) {
		super();
		this.cdRestricao = cdRestricao;
		this.txtRestricao = txtRestricao;
		this.tpRestricao = tpRestricao;
		this.stRestricao = stRestricao;
		this.dtRestricao = dtRestricao;
		this.veiculo = veiculo;
	}

	public int getCdRestricao() {
		return cdRestricao;
	}

	public void setCdRestricao(int cdRestricao) {
		this.cdRestricao = cdRestricao;
	}

	public String getTxtRestricao() {
		return txtRestricao;
	}

	public void setTxtRestricao(String txtRestricao) {
		this.txtRestricao = txtRestricao;
	}

	public int getTpRestricao() {
		return tpRestricao;
	}

	public void setTpRestricao(int tpRestricao) {
		this.tpRestricao = tpRestricao;
	}

	public int getStRestricao() {
		return stRestricao;
	}

	public void setStRestricao(int stRestricao) {
		this.stRestricao = stRestricao;
	}

	public LocalDate getDtRestricao() {
		return dtRestricao;
	}

	public void setDtRestricao(LocalDate dtRestricao) {
		this.dtRestricao = dtRestricao;
	}
	
	public int getCdVeiculo() {
		return cdVeiculo;
	}

	public void setCdVeiculo(int cdVeiculo) {
		this.cdVeiculo = cdVeiculo;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Restricao [cdRestricao=" + cdRestricao + ", txtRestricao=" + txtRestricao + ", tpRestricao="
				+ tpRestricao + ", stRestricao=" + stRestricao + ", dtRestricao=" + dtRestricao + ", veiculo=" + veiculo
				+ "]";
	}

}
