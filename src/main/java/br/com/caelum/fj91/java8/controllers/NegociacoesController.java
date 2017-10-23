package br.com.caelum.fj91.java8.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.fj91.java8.models.Negociacao;
import br.com.caelum.fj91.java8.repositories.NegociacaoRepository;

@Controller
@RequestMapping("/negociacoes")
public class NegociacoesController {
	
	private static final String PAGINA_NEGOCIACOES = "negociacoes/negociacoes";
	private static final String REDIRECT_PAGINA_NEGOCIACOES = "redirect:/negociacoes";
	
	private final NegociacaoRepository negociacaoRepository;

	public NegociacoesController(NegociacaoRepository negociacaoRepository) {
		this.negociacaoRepository = negociacaoRepository;
	}

	@GetMapping
	public String listar(Model model) {
		model.addAttribute("negociacoes", negociacaoRepository.findAllByOrderByDataDesc());
		return PAGINA_NEGOCIACOES;
	}
	
	@PostMapping
	@Transactional
	public String adicionar(Negociacao negociacao) {
		this.negociacaoRepository.save(negociacao);
		return REDIRECT_PAGINA_NEGOCIACOES;
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public String remover(@PathVariable("id") Long id) {
		this.negociacaoRepository.delete(id);
		return REDIRECT_PAGINA_NEGOCIACOES;
	}
	
}
