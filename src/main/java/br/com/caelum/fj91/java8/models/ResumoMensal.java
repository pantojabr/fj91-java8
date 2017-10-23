package br.com.caelum.fj91.java8.models;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class ResumoMensal {

	private final YearMonth mes;
	private final Integer quantidade;
	private final BigDecimal volume;

	public ResumoMensal(YearMonth mes, Integer quantidade, BigDecimal volume) {
		this.mes = mes;
		this.quantidade = quantidade;
		this.volume = volume;
	}
	
	public String mesFormatado() {
		return mes.format(DateTimeFormatter.ofPattern("MM/yyyy"));
	}
	
	public YearMonth getMes() {
		return mes;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public BigDecimal getVolume() {
		return volume;
	}
	
}
