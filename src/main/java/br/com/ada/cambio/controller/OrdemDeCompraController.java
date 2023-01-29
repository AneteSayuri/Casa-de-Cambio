package br.com.ada.cambio.controller;

import br.com.ada.cambio.dto.OrdemDeCompraDTO;
import br.com.ada.cambio.model.Cliente;
import br.com.ada.cambio.model.OrdemDeCompra;
import br.com.ada.cambio.service.ClienteService;
import br.com.ada.cambio.service.OrdemDeCompraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ordem-de-compra")
public class OrdemDeCompraController {
    private final OrdemDeCompraService ordemDeCompraService;
    private final ClienteService clienteService;

    public OrdemDeCompraController(OrdemDeCompraService ordemDeCompraService, ClienteService clienteService) {
        this.ordemDeCompraService = ordemDeCompraService;
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<OrdemDeCompra> createOrder(@RequestBody OrdemDeCompraDTO ordemDeCompraDTO) {
//        Optional<Cliente> cliente = clienteService.findByCpf(ordemDeCompraDTO.getCpfCliente());
//        if(!cliente.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
        if (!ordemDeCompraDTO.getNumeroAgencia().matches("\\d{4}")) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<String> moedasValidas = Arrays.asList("USD", "EUR");
        if (!moedasValidas.contains(ordemDeCompraDTO.getMoeda())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        OrdemDeCompra ordemDeCompra = ordemDeCompraService.createOrder(ordemDeCompraDTO);
        return new ResponseEntity<>(ordemDeCompra, HttpStatus.CREATED);
    }

    @GetMapping("/cliente/{cpf}")
    public ResponseEntity<List<OrdemDeCompra>> getOrdersByClient(@PathVariable String cpf) {
        List<OrdemDeCompra> ordensDeCompra = ordemDeCompraService.findOrdersByClient(cpf);
        return new ResponseEntity<>(ordensDeCompra, HttpStatus.OK);
    }
}
