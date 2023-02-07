package com.ada.compra;

import com.ada.cliente.Cliente;
import com.ada.compra.exceptions.AgenciaInvalidaException;
import com.ada.compra.exceptions.ClienteInvalidoException;
import com.ada.compra.exceptions.MoedaInvalidaException;
import com.ada.compra.exceptions.ValorInvalidoException;
import com.ada.comum.EntidadeDuplicadaException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/ordem-de-compra")
public class OrdemDeCompraController {
    private final OrdemDeCompraService ordemDeCompraService;

    @PostMapping
    public ResponseEntity<OrdemDeCompra> add(@RequestBody OrdemDeCompraDTO ordemDeCompraDTO)  {
        return ResponseEntity.created(URI.create("/api/ordem-de-compra/" + ordemDeCompraDTO.getId_compra())).build();
    }

    @GetMapping
    public List<OrdemDeCompra> buscar(){
        return ordemDeCompraService.findAll();
    }

}


