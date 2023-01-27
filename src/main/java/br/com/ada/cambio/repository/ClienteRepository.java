package br.com.ada.cambio.repository;

import br.com.ada.cambio.model.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
