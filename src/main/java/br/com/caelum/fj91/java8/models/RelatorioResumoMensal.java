package br.com.caelum.fj91.java8.models;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RelatorioResumoMensal {
	
	private static SimpleDateFormat MES_ANO = new SimpleDateFormat("MM/yyyy");
	
	private List<ResumoMensal> resumos = new ArrayList<>();

	public RelatorioResumoMensal(List<Negociacao> negociacoes) {
		Map<String, List<Negociacao>> negociacoesAgrupadasPorMes = agruparNegociacoesPorMes(negociacoes);
		montarResumosMensais(negociacoesAgrupadasPorMes);
		ordenarResumo();
	}

	private Map<String, List<Negociacao>> agruparNegociacoesPorMes(List<Negociacao> negociacoes) {
//		return negociacoes.stream().collect(Collectors.groupingBy(n -> YearMonth.from(n.getData())));
		Map<String, List<Negociacao>> negociacoesAgrupadas = new HashMap<>();
		for (Negociacao negociacao : negociacoes) {
			String mes = MES_ANO.format(negociacao.getData().getTime());
			List<Negociacao> negociacoesDoMes = negociacoesAgrupadas.get(mes);
			if (negociacoesDoMes == null) {
				negociacoesDoMes = new ArrayList<>();
				negociacoesAgrupadas.put(mes, negociacoesDoMes);
			}
			negociacoesDoMes.add(negociacao);
		}
		
		return negociacoesAgrupadas;
	}
	
	private void montarResumosMensais(Map<String, List<Negociacao>> negociacoesAgrupadasPorMes) {
//		negociacoesAgrupadasPorMes.forEach((mes, negociacoesDoMes) -> {
//			Integer quantidadeNoMes = negociacoesDoMes.stream().mapToInt(Negociacao::getQuantidade).sum();
//			BigDecimal volumeNoMes = negociacoesDoMes.stream().map(Negociacao::volume).reduce(BigDecimal.ZERO, BigDecimal::add);
//			this.resumos.add(new ResumoMensal(mes, quantidadeNoMes, volumeNoMes));
//		});
		for (Map.Entry<String, List<Negociacao>> map : negociacoesAgrupadasPorMes.entrySet()) {
			Integer quantidadeNoMes = 0;
			BigDecimal volumeNoMes = BigDecimal.ZERO;
			for (Negociacao negociacao : map.getValue()) {
				quantidadeNoMes += negociacao.getQuantidade();
				volumeNoMes = volumeNoMes.add(negociacao.volume());
			}
			this.resumos.add(new ResumoMensal(map.getKey(), quantidadeNoMes, volumeNoMes));	
		}
	}
	
	private void ordenarResumo() {
//		this.resumos.sort((r1, r2) -> r2.getMes().compareTo(r1.getMes()));
		Collections.sort(this.resumos, new Comparator<ResumoMensal>() {
			@Override
			public int compare(ResumoMensal r1, ResumoMensal r2) {
				return r2.getMes().compareTo(r1.getMes());
			}
		});
	}
	
	public List<ResumoMensal> getResumos() {
		return resumos;
	}
	
}
