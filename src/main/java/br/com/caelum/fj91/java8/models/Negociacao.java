package br.com.caelum.fj91.java8.models;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Negociacao {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Calendar data;
	private Integer quantidade;
	private BigDecimal valor;
	
	public Negociacao() {
	}
	
	public Negociacao(Calendar data, Integer quantidade, BigDecimal valor) {
		this.data = data;
		this.quantidade = quantidade;
		this.valor = valor;
	}
	
	public long diasCorridos() {
		//return data.until(LocalDate.now(), ChronoUnit.DAYS);

		//Sera que assim realmente funciona?
		long now = Calendar.getInstance().getTimeInMillis();
		long dataInMillis = this.data.getTimeInMillis();
		long difference = now - dataInMillis;
		return difference / (1000 * 60 * 60 * 24);
	}
	
	public BigDecimal volume() {
		return valor.multiply(BigDecimal.valueOf(quantidade));
	}
	
	//GETTERS-SETTERS
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
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
