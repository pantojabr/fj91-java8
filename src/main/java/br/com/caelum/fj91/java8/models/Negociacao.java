package br.com.caelum.fj91.java8.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Negociacao {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate data;
	private Integer quantidade;
	private BigDecimal valor;
	
	public Negociacao() {
	}
	
	public Negociacao(LocalDate data, Integer quantidade, BigDecimal valor) {
		this.data = data;
		this.quantidade = quantidade;
		this.valor = valor;
	}
	
	public long diasCorridos() {
		return data.until(LocalDate.now(), ChronoUnit.DAYS);
	}
	
	public BigDecimal volume() {
		return valor.multiply(BigDecimal.valueOf(quantidade));
	}
	
	public String getDataFormatada() {
		return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	
	//GETTERS-SETTERS
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
}
