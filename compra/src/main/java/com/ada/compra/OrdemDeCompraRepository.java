package com.ada.compra;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdemDeCompraRepository extends CrudRepository<OrdemDeCompra, Long> {

}