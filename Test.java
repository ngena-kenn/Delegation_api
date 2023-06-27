package fr.sacem.api.service;

public class Test {

    public static void main(String[] args) {
        DelegationsSarefService delegationsSarefService = new DelegationsSarefService();
        delegationsSarefService.getCdeuoData();
        String newLabel = "new value new";
        String replac = "nouve";
        String updatedSql = newLabel.replaceFirst("new",replac);
        System.out.println(updatedSql);
    }
}
