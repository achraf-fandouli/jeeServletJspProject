package dao;


import model.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.util.List;

public class GestionClient extends Gestion {



    public GestionClient() {
        super();
    }

    public void init() {
        emf = Persistence.createEntityManagerFactory("clinique");
        em = emf.createEntityManager();
    }

    public void ajouter_client(Client c) {
        em.getTransaction().begin();//ouvrir connection avec la base de données
        em.persist(c);//convertir de jpql vers le sql
        em.getTransaction().commit();//enregistrer
    }

    public List<Client> findAll() {
        try {
            em.getTransaction().begin();
            List<Client> lc = em.createQuery("select c from Client c").getResultList();
            em.getTransaction().commit();
            return lc;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteClietnById(long id) {
        Client c = findClientById(id);
        try {
            em.getTransaction().begin();
            em.remove(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Client findClientById(long id) {
        try {
            em.getTransaction().begin();
            Client c = em.find(Client.class, id);
            em.getTransaction().commit();
            return c;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * public void updateClient(Client c) : update avec la méthode merge
     * @param c : retourner un client
     */
    public void updateClient(Client c){
        em.getTransaction().begin();
        //le mersge c'est l'update
        em.merge(c);
        em.getTransaction().commit();
    }


}
