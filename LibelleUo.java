package fr.sacem.api.model;

import com.fasterxml.jackson.annotation.JsonSetter;

public class LibelleUo {
    private String libelleUo;
    private String codeUo;

    public String getLibelleUo() {
        return libelleUo;
    }
    @JsonSetter("LIBUO")
    public void setLibelleUo(String libelleUo) {
        this.libelleUo = libelleUo;
    }

    public String getCodeUo() {
        return codeUo;
    }
    @JsonSetter("CDEUO")
    public void setCodeUo(String codeUo) {
        this.codeUo = codeUo;
    }
}

