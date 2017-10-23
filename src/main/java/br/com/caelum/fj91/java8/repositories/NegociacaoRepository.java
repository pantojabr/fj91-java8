package br.com.caelum.fj91.java8.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.caelum.fj91.java8.models.Negociacao;

@Repository
public interface NegociacaoRepository extends JpaRepository<Negociacao, Long> {
	
	List<Negociacao> findAllByOrderByDataDesc();

}
