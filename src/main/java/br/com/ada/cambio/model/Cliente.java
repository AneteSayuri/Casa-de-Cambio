package br.com.ada.cambio.model;

import br.com.ada.cambio.model.enums.EstadoCivil;
import br.com.ada.cambio.model.enums.Sexo;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(unique = true)
    private String cpf;
    private LocalDate dataNascimento;
    private EstadoCivil estadoCivil;
    private Sexo sexo;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }
}
