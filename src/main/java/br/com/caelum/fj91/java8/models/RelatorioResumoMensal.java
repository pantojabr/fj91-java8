package br.com.caelum.fj91.java8.models;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RelatorioResumoMensal {
	
	private List<ResumoMensal> resumos = new ArrayList<>();

	public RelatorioResumoMensal(List<Negociacao> negociacoes) {
		Map<YearMonth, List<Negociacao>> negociacoesAgrupadasPorMes = agruparNegociacoesPorMes(negociacoes);
		montarResumosMensais(negociacoesAgrupadasPorMes);
		ordenarResumo();
	}

	private Map<YearMonth, List<Negociacao>> agruparNegociacoesPorMes(List<Negociacao> negociacoes) {
		return negociacoes.stream().collect(Collectors.groupingBy(n -> YearMonth.from(n.getData())));
	}
	
	private void montarResumosMensais(Map<YearMonth, List<Negociacao>> negociacoesAgrupadasPorMes) {
		negociacoesAgrupadasPorMes.forEach((mes, negociacoesDoMes) -> {
			Integer quantidadeNoMes = negociacoesDoMes.stream().mapToInt(Negociacao::getQuantidade).sum();
			BigDecimal volumeNoMes = negociacoesDoMes.stream().map(Negociacao::volume).reduce(BigDecimal.ZERO, BigDecimal::add);
			this.resumos.add(new ResumoMensal(mes, quantidadeNoMes, volumeNoMes));
		});
	}
	
	private void ordenarResumo() {
		this.resumos.sort((r1, r2) -> r2.getMes().compareTo(r1.getMes()));
	}
	
	public List<ResumoMensal> getResumos() {
		return resumos;
	}
	
}
