package model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Client {

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
    @Column(name = "EMAIL", nullable = false, length = 30)
    private String email;

    @Basic
    @Column(name = "PASSWORD", nullable = false, length = 30)
    private String password;


    public Client() {
    }


    public Client(long id, String nom, String prenom, String email, String password) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
    }

    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL)
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id && Objects.equals(nom, client.nom) && Objects.equals(prenom, client.prenom) && Objects.equals(email, client.email) && Objects.equals(password, client.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, prenom, email, password);
    }
}
