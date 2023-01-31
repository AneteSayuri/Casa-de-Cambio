package br.com.ada.cambio.repository;


import br.com.ada.cambio.model.Cotacao;
import org.springframework.data.repository.CrudRepository;

public interface CotacaoRepository extends CrudRepository<Cotacao, Long> {
}
