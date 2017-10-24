package br.com.caelum.fj91.java8.models;

import java.math.BigDecimal;

public class ResumoMensal {

	private final String mes;
	private final Integer quantidade;
	private final BigDecimal volume;

	public ResumoMensal(String mes, Integer quantidade, BigDecimal volume) {
		this.mes = mes;
		this.quantidade = quantidade;
		this.volume = volume;
	}
	
	public String getMes() {
		return mes;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public BigDecimal getVolume() {
		return volume;
	}
	
}
