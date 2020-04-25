package br.com.mcord.alpr.bdv.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "bdv_veiculo")
public class Veiculo implements Serializable {
	
	private static final long serialVersionUID = 5235678677252215476L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cd_veiculo")
	private int cdVeiculo;
	
	@Column(name = "nr_placa")
	private String nrPlaca;
	
	@Column(name = "nr_renavan")
	private String nrRenavan;
	
	@Column(name = "tp_veiculo")
	private int tpVeiculo;
	
	@Column(name = "tp_carroceria")
	private int tpCarroceria;
	
	@Column(name = "nr_ano_modelo")
	private int nrAnoModelo;
	
	@Column(name = "nr_ano_fabricacao")
	private int nrAnoFabricacao;
	
	@Column(name = "nr_codigo_municipio")
	private int nrCodigoMunicipio;
	
	@Column(name = "nm_municipio")
	private String nmMunicipio;
	
	@Column(name = "sg_estado")
	private String sgEstado;
	
	@Column(name = "nr_codigo_marca")
	private int nrCodigoMarca;
	
	@Column(name = "nm_marca_modelo")
	private String nmMarcaModelo;
	
	@Column(name = "nr_codigo_cor")
	private int nrCodigoCor;
	
	@Column(name = "nm_cor")
	private String nmCor;
	
	@Column(name = "nr_codigo_especie")
	private int nrCodigoEspecie;
	
	@Column(name = "nm_especie")
	private String nmEspecie;
	
	@Column(name = "nm_tipo")
	private String nmTipo;
	
	@Column(name = "nm_categoria")
	private String nmCategoria;
	
	@Column(name = "dt_informacao")
	private LocalDate dtInformacao;
	
	@Column(name = "nr_chassi")
	private String nrChassi;
	
	@OneToMany(mappedBy = "veiculo", cascade = CascadeType.ALL)
	private Set<Restricao> restricoes;
	
	public Veiculo() {}
	
	public Veiculo(int cdVeiculo, String nrPlaca, String nrRenavan, int tpVeiculo, int tpCarroceria, int nrAnoModelo,
			int nrAnoFabricacao, int nrCodigoMunicipio, String nmMunicipio, String sgEstado, int nrCodigoMarca,
			String nmMarcaModelo, int nrCodigoCor, String nmCor, int nrCodigoEspecie, String nmEspecie, String nmTipo,
			String nmCategoria, LocalDate dtInformacao, String nrChassi) {
		super();
		this.cdVeiculo = cdVeiculo;
		this.nrPlaca = nrPlaca;
		this.nrRenavan = nrRenavan;
		this.tpVeiculo = tpVeiculo;
		this.tpCarroceria = tpCarroceria;
		this.nrAnoModelo = nrAnoModelo;
		this.nrAnoFabricacao = nrAnoFabricacao;
		this.nrCodigoMunicipio = nrCodigoMunicipio;
		this.nmMunicipio = nmMunicipio;
		this.sgEstado = sgEstado;
		this.nrCodigoMarca = nrCodigoMarca;
		this.nmMarcaModelo = nmMarcaModelo;
		this.nrCodigoCor = nrCodigoCor;
		this.nmCor = nmCor;
		this.nrCodigoEspecie = nrCodigoEspecie;
		this.nmEspecie = nmEspecie;
		this.nmTipo = nmTipo;
		this.nmCategoria = nmCategoria;
		this.dtInformacao = dtInformacao;
		this.nrChassi = nrChassi;
	}

	public int getCdVeiculo() {
		return cdVeiculo;
	}

	public void setCdVeiculo(int cdVeiculo) {
		this.cdVeiculo = cdVeiculo;
	}

	public String getNrPlaca() {
		return nrPlaca;
	}

	public void setNrPlaca(String nrPlaca) {
		this.nrPlaca = nrPlaca;
	}

	public String getNrRenavan() {
		return nrRenavan;
	}

	public void setNrRenavan(String nrRenavan) {
		this.nrRenavan = nrRenavan;
	}

	public int getTpVeiculo() {
		return tpVeiculo;
	}

	public void setTpVeiculo(int tpVeiculo) {
		this.tpVeiculo = tpVeiculo;
	}

	public int getTpCarroceria() {
		return tpCarroceria;
	}

	public void setTpCarroceria(int tpCarroceria) {
		this.tpCarroceria = tpCarroceria;
	}

	public int getNrAnoModelo() {
		return nrAnoModelo;
	}

	public void setNrAnoModelo(int nrAnoModelo) {
		this.nrAnoModelo = nrAnoModelo;
	}

	public int getNrAnoFabricacao() {
		return nrAnoFabricacao;
	}

	public void setNrAnoFabricacao(int nrAnoFabricacao) {
		this.nrAnoFabricacao = nrAnoFabricacao;
	}

	public int getNrCodigoMunicipio() {
		return nrCodigoMunicipio;
	}

	public void setNrCodigoMunicipio(int nrCodigoMunicipio) {
		this.nrCodigoMunicipio = nrCodigoMunicipio;
	}

	public String getNmMunicipio() {
		return nmMunicipio;
	}

	public void setNmMunicipio(String nmMunicipio) {
		this.nmMunicipio = nmMunicipio;
	}

	public String getSgEstado() {
		return sgEstado;
	}

	public void setSgEstado(String sgEstado) {
		this.sgEstado = sgEstado;
	}

	public int getNrCodigoMarca() {
		return nrCodigoMarca;
	}

	public void setNrCodigoMarca(int nrCodigoMarca) {
		this.nrCodigoMarca = nrCodigoMarca;
	}

	public String getNmMarcaModelo() {
		return nmMarcaModelo;
	}

	public void setNmMarcaModelo(String nmMarcaModelo) {
		this.nmMarcaModelo = nmMarcaModelo;
	}

	public int getNrCodigoCor() {
		return nrCodigoCor;
	}

	public void setNrCodigoCor(int nrCodigoCor) {
		this.nrCodigoCor = nrCodigoCor;
	}

	public String getNmCor() {
		return nmCor;
	}

	public void setNmCor(String nmCor) {
		this.nmCor = nmCor;
	}

	public int getNrCodigoEspecie() {
		return nrCodigoEspecie;
	}

	public void setNrCodigoEspecie(int nrCodigoEspecie) {
		this.nrCodigoEspecie = nrCodigoEspecie;
	}

	public String getNmEspecie() {
		return nmEspecie;
	}

	public void setNmEspecie(String nmEspecie) {
		this.nmEspecie = nmEspecie;
	}

	public String getNmTipo() {
		return nmTipo;
	}

	public void setNmTipo(String nmTipo) {
		this.nmTipo = nmTipo;
	}

	public String getNmCategoria() {
		return nmCategoria;
	}

	public void setNmCategoria(String nmCategoria) {
		this.nmCategoria = nmCategoria;
	}

	public LocalDate getDtInformacao() {
		return dtInformacao;
	}

	public void setDtInformacao(LocalDate dtInformacao) {
		this.dtInformacao = dtInformacao;
	}

	public String getNrChassi() {
		return nrChassi;
	}

	public void setNrChassi(String nrChassi) {
		this.nrChassi = nrChassi;
	}
	
	public Set<Restricao> getRestricoes() {
		return restricoes;
	}

	public void setRestricoes(Set<Restricao> restricoes) {
		this.restricoes = restricoes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Veiculo [cdVeiculo=" + cdVeiculo + ", nrPlaca=" + nrPlaca + ", nrRenavan=" + nrRenavan + ", tpVeiculo="
				+ tpVeiculo + ", tpCarroceria=" + tpCarroceria + ", nrAnoModelo=" + nrAnoModelo + ", nrAnoFabricacao="
				+ nrAnoFabricacao + ", nrCodigoMunicipio=" + nrCodigoMunicipio + ", nmMunicipio=" + nmMunicipio
				+ ", sgEstado=" + sgEstado + ", nrCodigoMarca=" + nrCodigoMarca + ", nmMarcaModelo=" + nmMarcaModelo
				+ ", nrCodigoCor=" + nrCodigoCor + ", nmCor=" + nmCor + ", nrCodigoEspecie=" + nrCodigoEspecie
				+ ", nmEspecie=" + nmEspecie + ", nmTipo=" + nmTipo + ", nmCategoria=" + nmCategoria + ", dtInformacao="
				+ dtInformacao + ", nrChassi=" + nrChassi + "]";
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return new Veiculo(
				this.getCdVeiculo(), 
				this.getNrPlaca(), 
				this.getNrRenavan(), 
				this.getTpVeiculo(), 
				this.getTpVeiculo(), 
				this.getNrAnoModelo(), 
				this.getNrAnoFabricacao(), 
				this.getNrCodigoMunicipio(), 
				this.getNmMunicipio(), 
				this.getSgEstado(), 
				this.getNrCodigoMarca(), 
				this.getNmMarcaModelo(), 
				this.getNrCodigoCor(), 
				this.getNmCor(), 
				this.getNrCodigoEspecie(), 
				this.getNmEspecie(), 
				this.getNmTipo(), 
				this.getNmCategoria(), 
				this.getDtInformacao(), 
				this.getNrChassi());
	}
}
