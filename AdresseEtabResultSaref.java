package fr.sacem.api.model;

import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

public class AdresseEtabResultSaref {
    private TableData table;

    public List<AdresseEtabSaref> adresseEtab;

    public TableData getTable() {
        return table;
    }

    public void setTable(TableData table) {
        this.table = table;
    }

    public List<AdresseEtabSaref> getAdresseEtab() {
        return adresseEtab;
    }
    @JsonSetter("rows")
    public void setAdresseEtab(List<AdresseEtabSaref> adresseEtab) {
        this.adresseEtab = adresseEtab;
    }
}
