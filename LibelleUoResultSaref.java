package fr.sacem.api.model;

import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

public class LibelleUoResultSaref {
    private TableData table;
    private List<LibelleUo> libellesUo;

    public TableData getTable() {
        return table;
    }

    public void setTable(TableData table) {
        this.table = table;
    }

    public List<LibelleUo> getLibellesUo() {
        return libellesUo;
    }
    @JsonSetter("rows")
    public void setLibellesUo(List<LibelleUo> libellesUo) {
        this.libellesUo = libellesUo;
    }
}
