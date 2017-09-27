package br.qxd.smartgrid.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/*
 * 
 * @author SmartGrid
 * Historico equivale ao aparelho mestre naquele endereço
 *
 */
@Entity
public class Historico_consumo {

	@Id
	@GeneratedValue
	private long id;
	
	/*
	 * Numero de serie ou identificação unica do arduino mestre
	 */
	@Column
	private String numero_serie;
	
	@OneToOne(mappedBy="historico")
	private Endereco_usuario endereco;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumero_serie() {
		return numero_serie;
	}

	public void setNumero_serie(String numero_serie) {
		this.numero_serie = numero_serie;
	}

	public Endereco_usuario getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco_usuario endereco) {
		this.endereco = endereco;
	}
	
	
}
