package it.epicode;

import com.github.javafaker.Faker;
import it.epicode.gestione_eventi.dao.EventoDAO;
import it.epicode.gestione_eventi.entity.Evento;
import it.epicode.gestione_eventi.entity.EventoEnum;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.Locale;

public class MainDAO {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit-jpa");

        Faker faker = new Faker(new Locale("it"));

        EntityManager em = emf.createEntityManager();
        EventoDAO eventoDAO = new EventoDAO(em);

        Evento newEvent=new Evento();
        newEvent.setTitolo("party rock");
        newEvent.setDataEvento(faker.date().future(10, java.util.concurrent.TimeUnit.DAYS));
        newEvent.setTitolo("Sesso droga e rock and roll");
        newEvent.setTipoEvento(EventoEnum.PRIVATO);
        newEvent.setNumeroMassimoPartecipanti(500);

        eventoDAO.insertEvento(newEvent);

      
        em.close();


    }
}
