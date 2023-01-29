package br.com.ada.cambio.repository;

import br.com.ada.cambio.model.Cliente;
import br.com.ada.cambio.model.OrdemDeCompra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdemDeCompraRepository extends JpaRepository<OrdemDeCompra, Long> {
    List<OrdemDeCompra> findByCliente(Cliente cliente);
}
