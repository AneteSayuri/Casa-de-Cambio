package com.ada.compra;


import com.ada.compra.enums.Moeda;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class OrdemDeCompraDTO {
    private Long id_compra;
    private Long id_cliente;
    private String cpf_cliente;
    private LocalDate dataSolicitacao;
    private Moeda tipo_moeda;
    private BigDecimal valor_moeda_estrangeira;
    private BigDecimal valor_cotacao;
    private BigDecimal valor_total_operacao;
    private String numero_agencia_retirada;

    public static OrdemDeCompraDTO of(OrdemDeCompra ordemDeCompra) {
        OrdemDeCompraDTO dto = new OrdemDeCompraDTO();
        dto.setId_compra(ordemDeCompra.getId_compra());
        dto.setId_cliente(ordemDeCompra.getId_cliente());
        dto.setCpf_cliente(ordemDeCompra.getCpf_cliente());
        dto.setDataSolicitacao(ordemDeCompra.getDataSolicitacao());
        dto.setTipo_moeda(ordemDeCompra.getTipo_moeda());
        dto.setValor_moeda_estrangeira(ordemDeCompra.getValor_moeda_estrangeira());
        dto.setValor_cotacao(ordemDeCompra.getValor_cotacao());
        dto.setValor_total_operacao(ordemDeCompra.getValor_total_operacao());
        dto.setNumero_agencia_retirada(ordemDeCompra.getNumero_agencia_retirada());
        return dto;
    }

    public OrdemDeCompra toEntity() {
        OrdemDeCompra entity = new OrdemDeCompra();
        entity.setId_compra(id_compra);
        entity.setId_cliente(id_cliente);
        entity.setCpf_cliente(cpf_cliente);
        entity.setDataSolicitacao(dataSolicitacao);
        entity.setTipo_moeda(tipo_moeda);
        entity.setValor_moeda_estrangeira(valor_moeda_estrangeira);
        entity.setValor_cotacao(valor_cotacao);
        entity.setValor_total_operacao(valor_total_operacao);
        entity.setNumero_agencia_retirada(numero_agencia_retirada);
        return entity;
    }
}
