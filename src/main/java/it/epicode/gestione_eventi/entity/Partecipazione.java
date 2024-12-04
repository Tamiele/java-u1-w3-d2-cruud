package it.epicode.gestione_eventi.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "partecipazione")
public class Partecipazione {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)


    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatoPartecipazioneEnum stato;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    @ManyToOne
    @JoinColumn(name = "perosna_id")
    private Persona persona;
}
