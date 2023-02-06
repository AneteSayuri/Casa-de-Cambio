package com.ada.compra;

import com.ada.cotacao.CotacaoDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrdemDeCompraService {
    private final CrudRepository<OrdemDeCompra, Long> repository;
    private final CotacaoAPI cotacaoAPI;

    public OrdemDeCompraService(CrudRepository<OrdemDeCompra, Long> repository, CotacaoAPI cotacaoAPI) {
        this.repository = repository;
        this.cotacaoAPI = cotacaoAPI;
    }

    public void criarOrdemDeCompra(OrdemDeCompra entity) { //throws EntidadeDuplicadaException, OrdenDeCompraInvalidaException
        /**
         * Para criar a Ordem de Compra, precisa:
         * - Confirmar que o cliente existe (consultar a API Cliente)
         * - Confirmar se a moeda é válida (consultar enum)*
         * - Confirmar se q auantia é válida (>0 e usando .)
         * ? Confirmar se a agencia é válida (Regex)
         */

    //getCotacao -> cotacaoDTO
    //CONSERTAR ESTA LÓGICA ASAP (Amanda)
    /*public OrdemDeCompra obterCotacao(OrdemDeCompra entity) {
            if(getMoeda = EUR...)
            CotacaoDTO cotacao = new CotacaoDTO().getCotacao(OrdemDeCompra.getMoeda().toString());

            ordemDeCompra.setValorCotação(cotacaoDTO.getAsk())
            ordemCompra.setValorTotalOperação(cotacaoDTO.getAsk() * ordemDeCompra.getQuantiaEstrangeira());
            ordemCompra.setDataSolicitacao(cotacaoDTO.getCreate_date);

            return ordemDeCompra;
        }*/



    }
}

