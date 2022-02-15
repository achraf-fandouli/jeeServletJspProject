package dao;

import model.Medecin;
import model.Rdv;

import java.util.List;

public class GestionRdv extends Gestion {

    public GestionRdv() {
        super();
    }

    public void ajoutRdv(Rdv rdv) {

        em.getTransaction().begin();
        em.persist(rdv);
        em.getTransaction().commit();
    }


    public List<Rdv> findAll() {
        try {
            em.getTransaction().begin();
            List<Rdv> rdvs = em.createQuery("select r from Rdv r").getResultList();
            em.getTransaction().commit();
            return rdvs;
        } catch (Exception e) {
            return null;
        }
    }


    public Rdv findRdvById(long id){
        try {
            em.getTransaction().begin();
            Rdv rdv = em.find(Rdv.class,id);
            em.getTransaction().commit();
            return rdv;
        }catch(Exception e){
            return null;
        }
    }

    public void deleteRdv(long id){
        Rdv rdv = findRdvById(id);
        if(rdv != null)
        {
            em.getTransaction().begin();
            em.remove(rdv);
            em.getTransaction().commit();
        }

    }

    public void updateRdv(Rdv rdv){
        em.getTransaction().begin();
        em.merge(rdv);
        em.getTransaction().commit();
    }
}
