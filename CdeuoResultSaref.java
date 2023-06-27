package fr.sacem.api.model;

import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

public class CdeuoResultSaref {
    private TableData table;

    public List<CdeuoSaref> codesUo;

    public TableData getTable() {
        return table;
    }

    public void setTable(TableData table) {
        this.table = table;
    }

    public List<CdeuoSaref> getCodesUo() {
        return codesUo;
    }
    @JsonSetter("rows")
    public void setCodesUo(List<CdeuoSaref> codesUo) {
        this.codesUo = codesUo;
    }
}
