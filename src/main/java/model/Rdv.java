package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Rdv {

    @Id
    @Column(name = "ID", nullable = false)
    private long id;

    @Basic
    @Column(name = "JOUR", nullable = false, length = 30)
    private String jour;


    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_Client", referencedColumnName = "ID")
    private Client client;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_Medecin", referencedColumnName = "ID")
    private Medecin medecin;

    public Rdv(){
        this.client = new Client();
        this.medecin = new Medecin();
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rdv rdv = (Rdv) o;
        return id == rdv.id && Objects.equals(jour, rdv.jour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, jour);
    }
}
