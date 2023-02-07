package com.ada.cliente;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ClienteDTO {
    private Long id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private EstadoCivil estadoCivil;
    private Sexo sexo;


    public static ClienteDTO of(Cliente cliente) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.id = cliente.getId();
        clienteDTO.nome = cliente.getNome();
        clienteDTO.cpf = cliente.getCpf();
        clienteDTO.dataNascimento = cliente.getDataNascimento();
        clienteDTO.estadoCivil = cliente.getEstadoCivil();
        clienteDTO.sexo = cliente.getSexo();
        return clienteDTO;
    }

    public Cliente toEntity() {
        Cliente clienteEntity = new Cliente();
        clienteEntity.setId(id);
        clienteEntity.setNome(nome);
        clienteEntity.setCpf(cpf);
        clienteEntity.setDataNascimento(dataNascimento);
        clienteEntity.setEstadoCivil(estadoCivil);
        clienteEntity.setSexo(sexo);
        return clienteEntity;
    }

}
