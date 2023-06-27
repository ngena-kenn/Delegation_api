package fr.sacem.api.model;

import com.fasterxml.jackson.annotation.JsonSetter;

public class AdresseEtab {
    private String numeroVoie;
    private String add1Complement;
    private String add2Voie;
    private String add3BoitePostal;
    private String add4EtabAdresse4;
    private String codePostal;
    private String ville;

    public String getNumeroVoie() {
        return numeroVoie;
    }
    @JsonSetter("NUMVOIE")
    public void setNumeroVoie(String numeroVoie) {
        this.numeroVoie = numeroVoie;
    }

    public String getAdd1Complement() {
        return add1Complement;
    }
    @JsonSetter("ADRESSE_1")
    public void setAdd1Complement(String add1Complement) {
        this.add1Complement = add1Complement;
    }

    public String getAdd2Voie() {
        return add2Voie;
    }
    @JsonSetter("ADRESSE_2")
    public void setAdd2Voie(String add2Voie) {
        this.add2Voie = add2Voie;
    }

    public String getAdd3BoitePostal() {
        return add3BoitePostal;
    }
    @JsonSetter("ADRESSE_3")
    public void setAdd3BoitePostal(String add3BoitePostal) {
        this.add3BoitePostal = add3BoitePostal;
    }

    public String getAdd4EtabAdresse4() {
        return add4EtabAdresse4;
    }
    @JsonSetter("ADRESSE_4")
    public void setAdd4EtabAdresse4(String add4EtabAdresse4) {
        this.add4EtabAdresse4 = add4EtabAdresse4;
    }

    public String getCodePostal() {
        return codePostal;
    }
    @JsonSetter("CP")
    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }
    @JsonSetter("VILLE")
    public void setVille(String ville) {
        this.ville = ville;
    }
}
