package dao;

import model.Medecin;

import java.util.List;

public class GestionMedecin extends Gestion{

    public GestionMedecin() {
        super();
    }

    public void ajoutMedecin(Medecin med){

        em.getTransaction().begin();
        em.persist(med);
        em.getTransaction().commit();
    }

    public Medecin findMedById(long id){
        try {
            em.getTransaction().begin();
            Medecin medecin = em.find(Medecin.class,id);
            em.getTransaction().commit();
            return  medecin;
        }
        catch (Exception e){
            return null;

        }

    }

    public void deleteMedecin(long id){
        Medecin medecin = findMedById(id);
        if(medecin != null)
        {
            em.getTransaction().begin();
            em.remove(medecin);
            em.getTransaction().commit();
        }

    }

    public void updateMed(Medecin med){
        em.getTransaction().begin();
        em.merge(med);
        em.getTransaction().commit();
    }



    public List<Medecin> findAll(){
        try {
            em.getTransaction().begin();
            List<Medecin> listmed = em.createQuery("select m from Medecin m").getResultList();
            em.getTransaction().commit();
            return listmed;
        }catch (Exception e){
            return null;

        }

    }
}
