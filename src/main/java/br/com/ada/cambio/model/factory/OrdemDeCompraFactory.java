package br.com.ada.cambio.model.factory;

import br.com.ada.cambio.model.Cliente;
import br.com.ada.cambio.model.OrdemDeCompra;
import br.com.ada.cambio.model.enums.Moeda;
import br.com.ada.cambio.service.ClienteService;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class OrdemDeCompraFactory {
    public OrdemDeCompra create(String cpf, String moeda, BigDecimal quantiaEstrangeira, String numeroAgencia){
        return new OrdemDeCompra(cpf, moeda, quantiaEstrangeira, numeroAgencia);
    }
}
