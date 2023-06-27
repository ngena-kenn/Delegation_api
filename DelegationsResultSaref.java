package fr.sacem.api.model;

import java.util.List;

public class DelegationsResultSaref {
    private TableData table;
    public List<DelegationsSaref> codesUo;

    public TableData getTable() {
        return table;
    }

    public void setTable(TableData table) {
        this.table = table;
    }

    public List<DelegationsSaref> getCodesUo() {
        return codesUo;
    }

    public void setCodesUo(List<DelegationsSaref> codesUo) {
        this.codesUo = codesUo;
    }
}
