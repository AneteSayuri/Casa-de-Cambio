package com.ada.compra;
import com.ada.cliente.ClienteDTO;
import com.ada.compra.exceptions.*;
import com.ada.comum.EntidadeDuplicadaException;
import com.ada.cotacao.CotacaoDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import java.math.BigDecimal;
import java.util.List;

import static java.math.BigDecimal.ZERO;

@Service
public class OrdemDeCompraService {
    private final CrudRepository<OrdemDeCompra, Long> repository;
    private final CotacaoAPIClient cotacaoAPIClient;
    private final ClienteAPIClient clienteAPIClient;

    public OrdemDeCompraService(CrudRepository<OrdemDeCompra, Long> repository, CotacaoAPIClient cotacaoAPIClient, ClienteAPIClient clienteAPIClient) {
        this.repository = repository;
        this.cotacaoAPIClient = cotacaoAPIClient;
        this.clienteAPIClient = clienteAPIClient;
    }

    public void criarOrdemDeCompra(OrdemDeCompra entity) throws EntidadeDuplicadaException, ClienteInvalidoException, MoedaInvalidaException, AgenciaInvalidaException, ValorInvalidoException, InvalidRegistrationException {
        if (repository.existsById(entity.getId_compra())) {
            throw new EntidadeDuplicadaException();
        }
        boolean clienteValido;
        try {
            clienteValido = clienteAPIClient.existeCliente(entity.getId_cliente().toString());
        } catch (RestClientException e) {
            throw new ClienteInvalidoException("Api de Cliente não disponível");
        }
        if (!clienteValido) {
            throw new ClienteInvalidoException("Id de cliente não encontrado!");
        }
        if (!entity.getTipo_moeda().equals("EUR") && !entity.getTipo_moeda().equals("USD")) {
            throw new MoedaInvalidaException("A moeda deve ser USD ou EUR");
        }
        BigDecimal valorMoedaEstrangeira = entity.getValor_moeda_estrangeira();
        if (valorMoedaEstrangeira.compareTo(ZERO) == 0) {
            throw new ValorInvalidoException("O valor da moeda estrangeira deve ser maior que zero");
        }
        String agencia = String.valueOf(entity.getNumero_agencia_retirada());
        if (!agencia.matches("\\d{4}")) {
            throw new AgenciaInvalidaException("A agência deve ter 4 dígitos");
        }

        ClienteDTO cliente = clienteAPIClient.obterCliente(entity.getCpf_cliente());
        entity = obterCotacao(entity);
        entity.setId_cliente(cliente.getId());
        repository.save(entity);
    }
    public OrdemDeCompra obterCotacao(OrdemDeCompra entity) {
            CotacaoDTO cotacaoDTO = cotacaoAPIClient.getCotacao(entity.getTipo_moeda().toString());
            entity.setValor_cotacao(cotacaoDTO.getAsk());
            BigDecimal askCotacao = cotacaoDTO.getAsk();
            BigDecimal valorMoedaEstrangeira = entity.getValor_moeda_estrangeira();
            entity.setValor_total_operacao(askCotacao.multiply(valorMoedaEstrangeira)) ;
            entity.setDataSolicitacao(cotacaoDTO.getCreate_date());
            return entity;
        }

    public List<OrdemDeCompra> findAll() {
        return (List<OrdemDeCompra>) repository.findAll();
    }
}

