package br.com.ada.cambio.dto;

import br.com.ada.cambio.model.Cliente;
import br.com.ada.cambio.model.enums.EstadoCivil;
import br.com.ada.cambio.model.enums.Sexo;
import lombok.Data;

import java.time.LocalDate;
@Data
public class ClienteDTO {
    private final String cpf;
    private final String nome;
    private LocalDate dataNascimento;
    private EstadoCivil estadoCivil;
    private Sexo sexo;


    public static ClienteDTO of(Cliente cliente) {
        ClienteDTO clienteDTO = new ClienteDTO(cliente.getCpf(), cliente.getNome());
        clienteDTO.dataNascimento = cliente.getDataNascimento();
        clienteDTO.estadoCivil = cliente.getEstadoCivil();
        clienteDTO.sexo = cliente.getSexo();
        return clienteDTO;
    }

    public Cliente toEntity() {
        Cliente clienteEntity = new Cliente();
        clienteEntity.setNome(nome);
        clienteEntity.setCpf(cpf);
        clienteEntity.setDataNascimento(dataNascimento);
        clienteEntity.setEstadoCivil(estadoCivil);
        clienteEntity.setSexo(sexo);
        return clienteEntity;
    }

}
