package model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Medecin {

    @Id
    @Column(name = "ID", nullable = false)
    private long id;

    @Basic
    @Column(name = "NOM", nullable = false, length = 30)
    private String nom;

    @Basic
    @Column(name = "PRENOM", nullable = false, length = 30)
    private String prenom;

    @Basic
    @Column(name = "SPECIALITE", nullable = false, length = 30)
    private String specialite;



    @OneToMany(mappedBy = "medecin",cascade = CascadeType.ALL)
    private List<Rdv> rdvs;

    public List<Rdv> getRdvs() {
        return rdvs;
    }

    public void setRdvs(List<Rdv> rdvs) {
        this.rdvs = rdvs;
    }




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }


    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medecin medecin = (Medecin) o;
        return id == medecin.id && Objects.equals(nom, medecin.nom) && Objects.equals(prenom, medecin.prenom) && Objects.equals(specialite, medecin.specialite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, prenom, specialite);
    }
}
