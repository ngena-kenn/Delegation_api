package fr.sacem.api.model;

import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

public class EtablissementResultSaref {
    private TableData table;

    public List<EtablissementSaref> etablissement;

    public TableData getTable() {
        return table;
    }

    public void setTable(TableData table) {
        this.table = table;
    }

    public List<EtablissementSaref> getEtablissement() {
        return etablissement;
    }
    @JsonSetter("rows")
    public void setEtablissement(List<EtablissementSaref> etablissement) {
        this.etablissement = etablissement;
    }


}
