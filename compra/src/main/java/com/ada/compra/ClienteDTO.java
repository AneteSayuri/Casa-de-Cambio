package com.ada.compra;

import com.ada.cliente.EstadoCivil;
import com.ada.cliente.Sexo;
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

    public ClienteDTO() {
    }

    public ClienteDTO(Long id, String nome, String cpf, LocalDate dataNascimento, EstadoCivil estadoCivil, Sexo sexo) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.estadoCivil = estadoCivil;
        this.sexo = sexo;
    }
}
