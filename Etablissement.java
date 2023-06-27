package fr.sacem.api.model;

import com.fasterxml.jackson.annotation.JsonSetter;

public class Etablissement {
    private String codeEtablissement;
    private String codeNic;
    private String gpsLongitude;
    private String gpsLaltitude;

    public String getCodeEtablissement() {
        return codeEtablissement;
    }
    @JsonSetter("CDEETAB")
    public void setCodeEtablissement(String codeEtablissement) {
        this.codeEtablissement = codeEtablissement;
    }

    public String getCodeNic() {
        return codeNic;
    }
    @JsonSetter("NIC")
    public void setCodeNic(String codeNic) {
        this.codeNic = codeNic;
    }

    public String getGpsLongitude() {
        return gpsLongitude;
    }
    @JsonSetter("GPSLONGITUDE")
    public void setGpsLongitude(String gpsLongitude) {
        this.gpsLongitude = gpsLongitude;
    }

    public String getGpsLaltitude() {
        return gpsLaltitude;
    }
    @JsonSetter("GPSLATITUDE")
    public void setGpsLaltitude(String gpsLaltitude) {
        this.gpsLaltitude = gpsLaltitude;
    }
}
