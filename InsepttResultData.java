package fr.sacem.api.model;

import java.util.List;

public class InsepttResultData {
    private TableData table;
    public List<InseepttSaref> rows;

    public TableData getTable() {
        return table;
    }

    public void setTable(TableData table) {
        this.table = table;
    }

    public List<InseepttSaref> getRows() {
        return rows;
    }

    public void setRows(List<InseepttSaref> rows) {
        this.rows = rows;
    }
}
