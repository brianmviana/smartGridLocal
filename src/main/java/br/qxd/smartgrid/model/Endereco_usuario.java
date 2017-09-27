package br.qxd.smartgrid.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Endereco_usuario {

	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne
	private Usuario user;
	
	@Column
	private String street;
	
	@Column
	private int numero;
	
	@Column
	private String cidade;
	
	@Column
	private String estado;
	
	@Column
	private String cep;
	
	@Column
	private String bairro;
	
	@OneToOne
	@JoinColumn(name="historico")
	private Historico_consumo historico;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Historico_consumo getHistorico() {
		return historico;
	}

	public void setHistorico(Historico_consumo historico) {
		this.historico = historico;
	}
	
	
	
}
