package br.com.ada.cambio.service;

import br.com.ada.cambio.dto.OrdemDeCompraDTO;
import br.com.ada.cambio.model.Cliente;
import br.com.ada.cambio.model.OrdemDeCompra;
import br.com.ada.cambio.model.factory.OrdemDeCompraFactory;
import br.com.ada.cambio.repository.OrdemDeCompraRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class OrdemDeCompraService {

    private final OrdemDeCompraRepository ordemDeCompraRepository;
    private final OrdemDeCompraFactory ordemDeCompraFactory;
    private final ClienteService clienteService;
    public OrdemDeCompraService(OrdemDeCompraRepository ordemDeCompraRepository, OrdemDeCompraFactory ordemDeCompraFactory, ClienteService clienteService) {
        this.ordemDeCompraRepository = ordemDeCompraRepository;
        this.ordemDeCompraFactory = ordemDeCompraFactory;
        this.clienteService = clienteService;
    }
    public OrdemDeCompra createOrder(OrdemDeCompraDTO ordemDeCompraDTO) {
        OrdemDeCompra ordemDeCompra = new OrdemDeCompra(ordemDeCompraDTO.getCpfCliente(), ordemDeCompraDTO.getMoeda(), ordemDeCompraDTO.getQuantiaEstrangeira(), ordemDeCompraDTO.getNumeroAgencia());
        ordemDeCompra = ordemDeCompraRepository.save(ordemDeCompra);
        return ordemDeCompra;
    }

    public List<OrdemDeCompra> findOrdersByClient(String cpf) {
        Optional<Cliente> cliente = clienteService.findByCpf(cpf);
        if(cliente.isPresent()) {
            return ordemDeCompraRepository.findByCliente(cliente.get());
        } else {
            return Collections.emptyList();
        }
    }

//    public OrdemDeCompraFactory createOrder(String cpfCliente, List<AbstractReadWriteAccess.Item> items) {
//        Optional<Cliente> cliente = clienteService.findByCpf(cpfCliente);
//        return ordemDeCompraFactory.create(cliente, items);
//    }
}
