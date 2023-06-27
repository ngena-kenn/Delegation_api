package fr.sacem.api.service;

import fr.sacem.api.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DelegationsService{

    @Autowired
    private DelegationsSarefService delegationsSarefService;

    public CdeuoResultSaref getCdeuoSaref(){
        CdeuoResultSaref dataCdeuo =  delegationsSarefService.getCdeuoData();
        return dataCdeuo;
    }




    public List<DelegationsSaref> getDelegation(){
        List<DelegationsSaref> delegationsSarefs = new ArrayList<>();
        CdeuoResultSaref cdeuoResultSaref = getCdeuoSaref();
        List<CdeuoSaref> row1 = cdeuoResultSaref.getCodesUo();

        for (CdeuoSaref t: row1){
            DelegationsSaref delegationsSaref = new DelegationsSaref();
            delegationsSaref.setId(t.getCdeuo());

            LibelleUoResultSaref libsUo = delegationsSarefService.getLibelleUoData(t.getCdeuo());
            List<LibelleUo> libellesUo = libsUo.getLibellesUo();
            if (libellesUo != null && libellesUo.size() > 0){
                LibelleUo libUo = libellesUo.get(0);
                delegationsSaref.setNom(libUo.getLibelleUo());
            }

            EtablissementResultSaref etabSaref = delegationsSarefService.getEtablissementData(t.getCdeetabaffect());
            List<EtablissementSaref> etablissements = etabSaref.getEtablissement();
            if (etablissements != null && etablissements.size() > 0){
                EtablissementSaref etabs = etablissements.get(0);
                delegationsSaref.setCodeNic(etabs.getCodeNic());
                delegationsSaref.setLongitude(etabs.getGpsLongitude());
                delegationsSaref.setLatitude(etabs.getGpsLaltitude());
            }

            AdresseEtabResultSaref addEtabSaref = delegationsSarefService.getAdresseEtabData(t.getCdeetabaffect());
            List<AdresseEtabSaref> adressesEtab = addEtabSaref.getAdresseEtab();
            if(adressesEtab != null && adressesEtab.size() > 0){
                AdresseEtabSaref addEtab =  adressesEtab.get(0);
                delegationsSaref.setNumero(addEtab.getNumeroVoie());
                delegationsSaref.setComplement(addEtab.getAdd1Complement());
                delegationsSaref.setVoie(addEtab.getAdd2Voie());
                delegationsSaref.setBoitePostale(addEtab.getAdd3BoitePostal());
                delegationsSaref.setEtabAdresse4(addEtab.getAdd4EtabAdresse4());
                delegationsSaref.setCodePostal(addEtab.getCodePostal());
                delegationsSaref.setVille(addEtab.getVille());
            }
            Manager people = delegationsSarefService.getManagerData(t.getResponuo());

            if (  people != null ){

                ManagerDto manag = new ManagerDto();
                manag.setCivility(people.getCivility());
                manag.setNom(people.getNom());
                manag.setPrenom(people.getPrenom());
                delegationsSaref.setEmail(people.getEmail());
                delegationsSaref.setTelephone(people.getTelephone());
                delegationsSaref.setManager(manag);

            }

            delegationsSarefs.add(delegationsSaref);
        }

        return delegationsSarefs;
    }
}
