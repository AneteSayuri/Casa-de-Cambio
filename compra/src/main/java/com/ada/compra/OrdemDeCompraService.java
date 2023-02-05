package com.ada.compra;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class OrdemDeCompraService {
    private final CrudRepository<OrdemDeCompra, Long> repository;

    public OrdemDeCompraService(CrudRepository<OrdemDeCompra, Long> repository) {
        this.repository = repository;
    }

    public void criarOrdemDeCompra(OrdemDeCompra entity) { //throws EntidadeDuplicadaException, OrdenDeCompraInvalidaException
        /**
         * Para criar a Ordem de Compra, precisa:
         * - Confirmar que o cliente existe (consultar a API Cliente)
         * - Confirmar se a moeda é válida (consultar enum)*
         * - Confirmar se q auantia é válida (>0 e usando .)
         * ? Confirmar se a agencia é válida (Regex)
         */

    }
}