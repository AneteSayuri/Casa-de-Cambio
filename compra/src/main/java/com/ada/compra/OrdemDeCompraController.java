package com.ada.compra;

import com.ada.comum.EntidadeDuplicadaException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/ordem-de-compra")
public class OrdemDeCompraController {
    private final OrdemDeCompraService ordemDeCompraService;

    @PostMapping

    public ResponseEntity<OrdemDeCompra> add(@RequestBody OrdemDeCompra ordemDeCompra) {
        if (ordemDeCompra == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informada uma ordem de compra válida");
        }
        if (ordemDeCompra.getCpf_cliente() == null || ordemDeCompra.getCpf_cliente().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informada uma ordem de compra com um cpf atrelado válido.");
        }
        if (ordemDeCompra.getTipo_moeda() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informada uma  ordem de compra com uma  moeda válida");
        }
        if (ordemDeCompra.getNumero_agencia_retirada() == null || ordemDeCompra.getNumero_agencia_retirada().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informada uma ordem de compra com uma agência válida");
        }

        OrdemDeCompra compra;
        try {
            compra = ordemDeCompraService.criarOrdemDeCompra(ordemDeCompra);
        } catch (EntidadeDuplicadaException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Já existe uma ordem de compra com o ID informado");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Ocorreu um erro desconhecido");
        }
        return new ResponseEntity<>(compra, HttpStatus.CREATED);

    }

    @GetMapping
    public List<OrdemDeCompra> buscar(){
        return ordemDeCompraService.findAll();
    }

}


