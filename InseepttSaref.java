package fr.sacem.api.model;

import com.fasterxml.jackson.annotation.JsonSetter;

public class InseepttSaref {
    private String insptt;
    private String local;
    private String codePostal;
    private String cdeuo;

    public String getInsptt() {
        return insptt;
    }

    @JsonSetter("INSPTT")
    public void setInsptt(String insptt) {
        this.insptt = insptt;
    }

    public String getLocal() {
        return local;
    }

    @JsonSetter("LOCAL")
    public void setLocal(String local) {
        this.local = local;
    }

    public String getCodePostal() {
        return codePostal;
    }

    @JsonSetter("CP")
    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getCdeuo() {
        return cdeuo;
    }

    @JsonSetter("CDEUO")
    public void setCdeuo(String cdeuo) {
        this.cdeuo = cdeuo;
    }
}
