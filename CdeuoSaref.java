package fr.sacem.api.model;

import com.fasterxml.jackson.annotation.JsonSetter;

public class CdeuoSaref {
    private String cdeuo;
    private String cdeetabaffect;
    private String responuo;
    private String typeAgence;

    public String getCdeuo() {
        return cdeuo;
    }
    @JsonSetter("CDEUO")
    public void setCdeuo(String cdeuo) {
        this.cdeuo = cdeuo;
    }

    public String getCdeetabaffect() {
        return cdeetabaffect;
    }
    @JsonSetter("CDEETABAFFECT")
    public void setCdeetabaffect(String cdeetabaffect) {
        this.cdeetabaffect = cdeetabaffect;
    }

    public String getResponuo() {
        return responuo;
    }
    @JsonSetter("RESPONUO")
    public void setResponuo(String responuo) {
        this.responuo = responuo;
    }

    public String getTypeAgence() {
        return typeAgence;
    }
    @JsonSetter("TYPAGENCE")
    public void setTypeAgence(String typAgence) {
        this.typeAgence = typAgence;
    }
}

