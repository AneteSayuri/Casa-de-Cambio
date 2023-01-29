package br.com.ada.cambio.model;

import br.com.ada.cambio.model.enums.Moeda;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Entity
@Getter
@Setter
public class OrdemDeCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Cliente cliente;

    private Moeda moeda;

    private BigDecimal quantiaEstrangeira;

    private String numeroAgencia;

    public OrdemDeCompra(String cpfCliente, String moeda, BigDecimal quantiaEstrangeira, String numeroAgencia) {

    }
}
