package br.com.unirio.agauto.controller.dto;

import br.com.unirio.agauto.persistence.entity.FormaDePagamento;
import br.com.unirio.agauto.persistence.entity.Sexo;
import br.com.unirio.agauto.persistence.entity.TipoCombustivel;

public class CompraDTO {
	private String proprName;
	private String proprNascimento;
	private Sexo proprSexo;
	private String proprTel;
	private String proprEmail;
	private String proprCpf;

	private String autoPlaca;
	private String autoAno;
	private String autoCor;
	private TipoCombustivel autoCombustivel;
	private Double autoPrecMinVenda;

	private String modNome;
	private String modAno;
	private String modFabricante;
	private Integer modNumPass;
	private Integer modCil;
	private Integer modNumPort;

	private FormaDePagamento pagForma;
	private Integer pagNumParc;
	private Double pagValEntr;
	private Double pagValPrest;

	private Long funcionario;

	public CompraDTO() {
	}

	public String getProprName() {
		return proprName;
	}

	public void setProprName(String proprName) {
		this.proprName = proprName;
	}

	public Sexo getProprSexo() {
		return proprSexo;
	}

	public void setProprSexo(Sexo proprSexo) {
		this.proprSexo = proprSexo;
	}

	public String getProprTel() {
		return proprTel;
	}

	public void setProprTel(String proprTel) {
		this.proprTel = proprTel;
	}

	public String getProprEmail() {
		return proprEmail;
	}

	public void setProprEmail(String proprEmail) {
		this.proprEmail = proprEmail;
	}

	public String getProprCpf() {
		return proprCpf;
	}

	public void setProprCpf(String proprCpf) {
		this.proprCpf = proprCpf;
	}

	public String getAutoPlaca() {
		return autoPlaca;
	}

	public void setAutoPlaca(String autoPlaca) {
		this.autoPlaca = autoPlaca;
	}

	public String getAutoCor() {
		return autoCor;
	}

	public void setAutoCor(String autoCor) {
		this.autoCor = autoCor;
	}

	public TipoCombustivel getAutoCombustivel() {
		return autoCombustivel;
	}

	public void setAutoCombustivel(TipoCombustivel autoCombustivel) {
		this.autoCombustivel = autoCombustivel;
	}

	public Double getAutoPrecMinVenda() {
		return autoPrecMinVenda;
	}

	public void setAutoPrecMinVenda(Double autoPrecMinVenda) {
		this.autoPrecMinVenda = autoPrecMinVenda;
	}

	public String getModNome() {
		return modNome;
	}

	public void setModNome(String modNome) {
		this.modNome = modNome;
	}

	public String getModFabricante() {
		return modFabricante;
	}

	public void setModFabricante(String modFabricante) {
		this.modFabricante = modFabricante;
	}

	public Integer getModNumPass() {
		return modNumPass;
	}

	public void setModNumPass(Integer modNumPass) {
		this.modNumPass = modNumPass;
	}

	public Integer getModCil() {
		return modCil;
	}

	public void setModCil(Integer modCil) {
		this.modCil = modCil;
	}

	public Integer getModNumPort() {
		return modNumPort;
	}

	public void setModNumPort(Integer modNumPort) {
		this.modNumPort = modNumPort;
	}

	public FormaDePagamento getPagForma() {
		return pagForma;
	}

	public void setPagForma(FormaDePagamento pagForma) {
		this.pagForma = pagForma;
	}

	public Integer getPagNumParc() {
		return pagNumParc;
	}

	public void setPagNumParc(Integer pagNumParc) {
		this.pagNumParc = pagNumParc;
	}

	public Double getPagValEntr() {
		return pagValEntr;
	}

	public void setPagValEntr(Double pagValEntr) {
		this.pagValEntr = pagValEntr;
	}

	public Double getPagValPrest() {
		return pagValPrest;
	}

	public void setPagValPrest(Double pagValPrest) {
		this.pagValPrest = pagValPrest;
	}

	public String getProprNascimento() {
		return proprNascimento;
	}

	public void setProprNascimento(String proprNascimento) {
		this.proprNascimento = proprNascimento;
	}

	public String getAutoAno() {
		return autoAno;
	}

	public void setAutoAno(String autoAno) {
		this.autoAno = autoAno;
	}

	public String getModAno() {
		return modAno;
	}

	public void setModAno(String modAno) {
		this.modAno = modAno;
	}

	public Long getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Long funcionario) {
		this.funcionario = funcionario;
	}

}
