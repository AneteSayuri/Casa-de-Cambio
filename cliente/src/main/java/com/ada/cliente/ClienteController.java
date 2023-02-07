package com.ada.cliente;

import com.ada.comum.EntidadeDuplicadaException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService service;
    @GetMapping("{cpf}")
    public ResponseEntity<ClienteDTO> getByCpf(@PathVariable String cpf) {
        if (cpf == null || cpf.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informado um CPF!");
        }
        String clearCpf = cpf.replaceAll("[\\.-]", "");
        Optional<Cliente> encontrado = service.findByCpf(cpf);
        Cliente entity = encontrado.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi localizada uma pessoa com o CPF informado!"));
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

        try {
            service.salvar(clienteDTO.toEntity());
        } catch (EntidadeDuplicadaException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Já existe uma pessoa com o CPF informado");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Ocorreu um erro desconhecido");
        }
        return ResponseEntity.created(URI.create("/cliente/" + clearCpf)).build();
    }

    @GetMapping
    public List<Cliente> buscar(){
        return service.findAll();
    }

}
