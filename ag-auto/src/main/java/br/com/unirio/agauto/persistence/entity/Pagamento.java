package br.com.unirio.agauto.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PAGAMENTO")
public class Pagamento implements Serializable {

	private static final long serialVersionUID = -7902168674084969277L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	private Date data;

	private FormaDePagamento formaDePagamento;

	private Integer numeroDeParcelas;

	private Double valorDeEntrada;

	private Double valorDePrestacoes;

	public Pagamento() {
	}

	public Pagamento(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public FormaDePagamento getFormaDePagamento() {
		return formaDePagamento;
	}

	public void setFormaDePagamento(FormaDePagamento formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}

	public Double getValorDeEntrada() {
		return valorDeEntrada;
	}

	public void setValorDeEntrada(Double valorDeEntrada) {
		this.valorDeEntrada = valorDeEntrada;
	}

	public Double getValorDePrestacoes() {
		return valorDePrestacoes;
	}

	public void setValorDePrestacoes(Double valorDePrestacoes) {
		this.valorDePrestacoes = valorDePrestacoes;
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
		Pagamento other = (Pagamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
