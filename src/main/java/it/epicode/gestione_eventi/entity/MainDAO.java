package it.epicode.gestione_eventi.entity;

import com.github.javafaker.Faker;
import it.epicode.gestione_eventi.dao.EventoDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


import java.util.Locale;

public class MainDAO {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit-jpa");
        Faker faker = new Faker(new Locale("it"));

        EntityManager em = emf.createEntityManager();
        EventoDAO eventoDAO = new EventoDAO(em);

        Evento evento = new Evento();
        evento.setTitolo("party rock");
        evento.setDataEvento(faker.date().future(10, java.util.concurrent.TimeUnit.DAYS));
        evento.setDescrizione("party super divertente");
        evento.setTipoEvento(EventoEnum.PRIVATO);
        evento.setNumeroMassimoPartecipanti(500);

        eventoDAO.insertEvento(evento);


        em.close();


    }
}
