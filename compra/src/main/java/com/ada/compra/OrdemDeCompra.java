package com.ada.compra;

import com.ada.compra.enums.Moeda;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
public class OrdemDeCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_compra;
    private Long id_cliente;
    private String cpf_cliente;
    private LocalDate dataSolicitacao;
    private Moeda tipo_moeda;
    private BigDecimal valor_moeda_estrangeira;
    private BigDecimal valor_cotacao;
    private BigDecimal valor_total_operacao;
    private String numero_agencia_retirada;

}