package br.com.jsousa.animal_service.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter
@Setter
public class Animal {

    private enum Especie {
        GATO,
        CACHORRO;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Especie especie;

    @Column(nullable = false)
    private String nomeProvisorio;

    @Column(nullable = false)
    private Integer idadeEstimada;

    @Column(nullable = false)
    private String raca;

    @Column(nullable = false)
    private Date dataEntrada;

    @Column
    private Date dataAdocao;

    @Column(nullable = false)
    private String condicoesChegada;

    @Column(nullable = false)
    private String nomeRecebedor;

    @Column
    private Date dataObito;

    @Column(nullable = false)
    private String porte;
}
