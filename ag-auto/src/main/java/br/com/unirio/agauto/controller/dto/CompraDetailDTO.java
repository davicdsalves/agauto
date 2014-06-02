package br.com.unirio.agauto.controller.dto;

public class CompraDetailDTO {
	private String placa;
	private String propNome;
	private String funcNome;
	private Double valCompra;

	public CompraDetailDTO() {
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getPropNome() {
		return propNome;
	}

	public void setPropNome(String propNome) {
		this.propNome = propNome;
	}

	public String getFuncNome() {
		return funcNome;
	}

	public void setFuncNome(String funcNome) {
		this.funcNome = funcNome;
	}

	public Double getValCompra() {
		return valCompra;
	}

	public void setValCompra(Double valCompra) {
		this.valCompra = valCompra;
	}

}
