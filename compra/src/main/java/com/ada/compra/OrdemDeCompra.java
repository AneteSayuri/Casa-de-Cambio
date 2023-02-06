package com.ada.compra;

import com.ada.compra.enums.Moeda;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class OrdemDeCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cliente;
    private Moeda moeda;
    private BigDecimal quantiaEstrangeira;
    private BigDecimal valorTotalEmReais;
    private String numeroAgencia;
}