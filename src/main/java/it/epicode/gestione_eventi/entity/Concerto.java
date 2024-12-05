package it.epicode.gestione_eventi.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "Concerti")
@NamedQuery(name = "Trova_tutto_Concerto", query = "SELECT a FROM Concerto a")
public class Concerto extends Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private GenereEnum genere;

    @Column(nullable = false)
    private boolean inStreaming;


}