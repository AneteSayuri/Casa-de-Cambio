package com.ada.compra;

import com.ada.compra.enums.Moeda;
import com.ada.cotacao.CotacaoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class OrdemDeCompraService {
    private Moeda moeda;
    private final CrudRepository<OrdemDeCompra, Long> repository;
    private final CotacaoAPIClient cotacaoAPIClient;

    public OrdemDeCompraService(CrudRepository<OrdemDeCompra, Long> repository, CotacaoAPIClient cotacaoAPIClient) {
        this.repository = repository;
        this.cotacaoAPIClient = cotacaoAPIClient;
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

