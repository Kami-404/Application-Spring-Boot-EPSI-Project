package fr.epsi.actor.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public class Actor {

    public static final Actor NOBODY = new Actor("nobody", "nobody", 0);

    @JsonAlias("firstname")
    private String nom;
    @JsonAlias("lastname")
    private String prenom;
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String nomAffichable() {
        return prenom + " " + nom + " [" + id + "]";
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Actor(String nom, String prenom, Integer id) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Actor() {
    };

    @Override
    public String toString() {

        return nomAffichable();
    }

}
