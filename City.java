package fr.sacem.api.model;

public class City {
    private String insptt;
    private String local;
    private String codePostal;
    private String cdeuo;

    public City(){

    }

    public City(String toto){
        codePostal = toto;
    }

    public City(String insptt, String local, String codePostal, String cdeuo) {
        this.insptt = insptt;
        this.local = local;
        this.cdeuo = cdeuo;
        this.codePostal = codePostal;
    }

    public String getInsptt() {
        return insptt;
    }

    public void setInsptt(String insptt) {
        this.insptt = insptt;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getCdeuo() {
        return cdeuo;
    }

    public void setCdeuo(String cdeuo) {
        this.cdeuo = cdeuo;
    }
}
