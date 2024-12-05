package it.epicode.gestione_eventi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "gare")
@NamedQuery(name = "Trova_tutto_GaraDiAtletica", query = "SELECT a FROM GaraDiAtletica a")
public class GaraDiAtletica extends Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany(mappedBy = "garaDiAtletica")
    private Set<Persona> atleti = new HashSet<>();

    //piu gare posso essere vinte da una sola persona
    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona vincitore;


}