package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;

public class Gestion {
    protected EntityManager em;
    protected EntityManagerFactory emf;


    public Gestion() {
    }

    public void close(){
     emf.close();
     em.close();
 }

    public void init() {
        emf = Persistence.createEntityManagerFactory("clinique");
        em = emf.createEntityManager();
    }
}
