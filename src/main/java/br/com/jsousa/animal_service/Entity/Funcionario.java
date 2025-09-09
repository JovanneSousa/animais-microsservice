package br.com.jsousa.animal_service.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Funcionario {
    private String nomeRecebedor;
    private Long quantidade;
}
