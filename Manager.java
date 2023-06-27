package fr.sacem.api.model;

import com.fasterxml.jackson.annotation.JsonSetter;

public class Manager {

    private String civility;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;



    public String getCivility() {
        return civility;
    }
    @JsonSetter("civilite")
    public void setCivility(String civility) {
        this.civility = civility;
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

    @JsonSetter("courriel")
    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}

