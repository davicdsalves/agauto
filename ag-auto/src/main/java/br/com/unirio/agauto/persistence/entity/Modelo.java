package br.com.unirio.agauto.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MODELO")
public class Modelo implements Serializable {

	private static final long serialVersionUID = 7424367845190772109L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	private String nome;

	private String ano;

	private String fabricante;

	private Integer numeroDePassageiros;

	private Integer cilindradas;

	private Integer numeroDePortas;

	public Modelo() {
	}

	public Modelo(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public Integer getNumeroDePassageiros() {
		return numeroDePassageiros;
	}

	public void setNumeroDePassageiros(Integer numeroDePassageiros) {
		this.numeroDePassageiros = numeroDePassageiros;
	}

	public Integer getCilindradas() {
		return cilindradas;
	}

	public void setCilindradas(Integer cilindradas) {
		this.cilindradas = cilindradas;
	}

	public Integer getNumeroDePortas() {
		return numeroDePortas;
	}

	public void setNumeroDePortas(Integer numeroDePortas) {
		this.numeroDePortas = numeroDePortas;
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
		Modelo other = (Modelo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
