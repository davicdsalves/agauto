package br.com.unirio.agauto.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AUTOMOVEL")
public class Automovel implements Serializable {

	private static final long serialVersionUID = 5148044352466096828L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	private String placa;

	private String anoDeFabricacao;

	private String cor;

	private TipoCombustivel combustivel;

	private Double precoMinimoDeVenda;

	@ManyToOne
	@JoinColumn(name = "ID_MODELO")
	private Modelo modelo;

	public Automovel() {
	}

	public Automovel(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getAnoDeFabricacao() {
		return anoDeFabricacao;
	}

	public void setAnoDeFabricacao(String anoDeFabricacao) {
		this.anoDeFabricacao = anoDeFabricacao;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public TipoCombustivel getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(TipoCombustivel combustivel) {
		this.combustivel = combustivel;
	}

	public Double getPrecoMinimoDeVenda() {
		return precoMinimoDeVenda;
	}

	public void setPrecoMinimoDeVenda(Double precoMinimoDeVenda) {
		this.precoMinimoDeVenda = precoMinimoDeVenda;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Automovel other = (Automovel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
