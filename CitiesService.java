package fr.sacem.api.service;



import fr.sacem.api.model.City;
import fr.sacem.api.model.InseepttSaref;
import fr.sacem.api.model.InsepttResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CitiesService {

    @Autowired
    private SsoApplicationService ssoApplicationService;

    @Autowired
    private InsepttSarefService insepttSarefService;

    public InsepttResultData getInspttSaref(){
       InsepttResultData dataInsptt =  insepttSarefService.getInspttData();
        return dataInsptt;
    }

    public List<City> getCities(){
        List<City> cities = new ArrayList<>();
        InsepttResultData insepttResultData = getInspttSaref();
        List<InseepttSaref> row1 = insepttResultData.getRows();

        for (InseepttSaref t: row1){
            City city = new City();
            city.setInsptt(t.getInsptt());
            city.setLocal(t.getLocal());
            city.setCodePostal(t.getCodePostal());
            city.setCdeuo(t.getCdeuo());
            cities.add(city);
        }
       // for(int i=0;i<row1.size();i++){
          //  InseepttSaref ins1= row1.get(i);

        return cities;

    }
}
