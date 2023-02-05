package com.example.compra;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/ordem-de-compra")
public class OrdemDeCompraController {
    private final OrdemDeCompraService ordemDeCompraService;
    @PostMapping
    public ResponseEntity<Void> add(@RequestBody OrdemDeCompraDTO ordemDeCompra) {
        if (ordemDeCompra == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informada uma ordem de compra válida");
        }
        if (ordemDeCompra.getCliente() == null || ordemDeCompra.getCliente().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informada uma reserva com uma cliente válido");
        }
        return ResponseEntity.created(URI.create("/api/ordem-de-compra/" + ordemDeCompra.getId())).build();
    }

}
