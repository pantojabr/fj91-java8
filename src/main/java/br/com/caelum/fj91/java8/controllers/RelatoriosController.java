package br.com.caelum.fj91.java8.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.fj91.java8.models.Negociacao;
import br.com.caelum.fj91.java8.models.RelatorioResumoMensal;
import br.com.caelum.fj91.java8.repositories.NegociacaoRepository;

@Controller
@RequestMapping("/relatorios")
public class RelatoriosController {
	
	private static final String PAGINA_RELATORIO_RESUMO_MENSAL = "relatorios/resumoMensal";
	
	private final NegociacaoRepository negociacaoRepository;

	public RelatoriosController(NegociacaoRepository negociacaoRepository) {
		this.negociacaoRepository = negociacaoRepository;
	}

	@GetMapping("/resumo-mensal")
	public String listar(Model model) {
		List<Negociacao> todas = negociacaoRepository.findAll();
		RelatorioResumoMensal relatorio = new RelatorioResumoMensal(todas);
		
		model.addAttribute("resumos", relatorio.getResumos());
		return PAGINA_RELATORIO_RESUMO_MENSAL;
	}
	
}
