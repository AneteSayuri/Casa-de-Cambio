package br.com.ada.cambio.controller;

import br.com.ada.cambio.dto.ClienteDTO;
import br.com.ada.cambio.model.Cliente;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @GetMapping("{cpf}")
    public ResponseEntity<ClienteDTO> getByCpf(@PathVariable String cpf) {
        if (cpf == null || cpf.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informado um CPF!");
        }
        String clearCpf = cpf.replaceAll("[\\.-]", "");
        Cliente entity = new Cliente(clearCpf, "CPF Fake");
        return ResponseEntity.ok(ClienteDTO.of(entity));
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody ClienteDTO clienteDTO) {
        if (clienteDTO == null || clienteDTO.getCpf() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informada uma pessoa válida");
        }
        String clearCpf = clienteDTO.getCpf().replaceAll("[\\.-]", "");
        if (clearCpf.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informada uma pessoa com CPF válido");
        }
        if (clienteDTO.getNome() == null || clienteDTO.getNome().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informada uma pessoa com Nome válido");
        }
        return ResponseEntity.created(URI.create("/cliente/" + clearCpf)).build();
    }

}
