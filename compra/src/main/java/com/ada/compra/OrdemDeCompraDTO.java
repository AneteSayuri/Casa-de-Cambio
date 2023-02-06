package com.ada.compra;


import com.ada.compra.enums.Moeda;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrdemDeCompraDTO {
    private Long id;
    private String cliente;
    private Moeda moeda;
    private BigDecimal quantiaEstrangeira;
    private String numeroAgencia;

    public static OrdemDeCompraDTO of(OrdemDeCompra ordemDeCompra) {
        OrdemDeCompraDTO dto = new OrdemDeCompraDTO();
        dto.setId(ordemDeCompra.getId());
        dto.setCliente(ordemDeCompra.getCliente());
        dto.setMoeda(ordemDeCompra.getMoeda());
        dto.setQuantiaEstrangeira(ordemDeCompra.getQuantiaEstrangeira());
        dto.setNumeroAgencia(ordemDeCompra.getNumeroAgencia());
        return dto;
    }

    public OrdemDeCompra toEntity() {
        OrdemDeCompra entity = new OrdemDeCompra();
        entity.setId(id);
        entity.setCliente(cliente);
        entity.setMoeda(moeda);
        entity.setQuantiaEstrangeira(quantiaEstrangeira);
        entity.setNumeroAgencia(numeroAgencia);
        return entity;
    }
}
