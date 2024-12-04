package it.epicode.gestione_eventi.dao;

import it.epicode.gestione_eventi.entity.Persona;
import jakarta.persistence.EntityManager;

import java.util.List;

public class PersonaDAO {

    private EntityManager em;

    public PersonaDAO(EntityManager em) {
        this.em = em;
    }

    public void insertPersona(Persona persona) {
        em.getTransaction().begin();
        em.persist(persona);
        em.getTransaction().commit();
    }

    public Persona findPersonaById(Long id) {
        return em.find(Persona.class, id);
    }

    public void updatePersona(Persona persona) {
        em.getTransaction().begin();
        em.merge(persona);
        em.getTransaction().commit();
    }

    public void updatePersona(Long id, Persona persona) {
        Persona peReale = findPersonaById(id);
        peReale.setNome(persona.getNome());
        peReale.setCognome(persona.getCognome());
        peReale.setDataDiNascita(persona.getDataDiNascita());
        peReale.setListaPartecipazioni(persona.getListaPartecipazioni());
        peReale.setSesso(persona.getSesso());

        em.getTransaction().begin();
        em.merge(peReale);
        em.getTransaction().commit();
    }

    public void deletePersona(Long id) {
        Persona peReale = findPersonaById(id);
        em.getTransaction().begin();
        em.remove(peReale);
        em.getTransaction().commit();
    }

    public void deletePersona(Persona persona) {
        em.getTransaction().begin();
        em.remove(persona);
        em.getTransaction().commit();
    }

    public void insertAll(List<Persona> lista) {
        em.getTransaction().begin();
        for (Persona e : lista) {
            em.persist(e);
        }
        em.getTransaction().commit();
    }
}
