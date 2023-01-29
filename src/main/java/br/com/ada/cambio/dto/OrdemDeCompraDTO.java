package br.com.ada.cambio.dto;

import br.com.ada.cambio.model.enums.Moeda;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OrdemDeCompraDTO {
    private Long id;

    private String cpfCliente;

    private String moeda;

    private BigDecimal quantiaEstrangeira;

    private String numeroAgencia;
}
