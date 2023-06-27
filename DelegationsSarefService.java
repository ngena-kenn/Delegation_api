package fr.sacem.api.service;

import fr.sacem.api.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class DelegationsSarefService{
    @Autowired
    private SsoApplicationService ssoApplicationService;
    @Autowired
    private FilesService filesService;

    @Autowired
    RestTemplate restTemplate;
    @Value("${request.cdeuo.url}")
    private String reqestCdeuoUrl;

    @Value("${request.libuo.url}")
    private String requestLibuoUrl;

    @Value("${request.etab.url}")
    private String requestEtabUrl;
    @Value("${request.adressEtab.url}")
    private String requestAddEtabUrl;

    @Value("${request.person.url}")
    private String requestPersonUrl;

    public CdeuoResultSaref getCdeuoData(){

        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plusDays(1);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formatToday = today.format(format);
        String formatTomorrow = tomorrow.format(format);

        String token = ssoApplicationService.getWessidToken();
        HttpHeaders headers = new HttpHeaders();
        headers.add("wessoAuthcookie",token);
        CdeuoResultSaref result = null;
        try {
            String cdeuoRequest = filesService.getFileContent("request/delCdeuoRequest.json");
            if (cdeuoRequest != null) {
                String cdeuoRequestfinal = cdeuoRequest
                        .replace("%startDate%", formatToday )
                        .replace("%endDate%", formatTomorrow);
                HttpEntity httpEntity = new HttpEntity(cdeuoRequestfinal, headers);
                ResponseEntity<CdeuoResultSaref> responseEntity = restTemplate.exchange(reqestCdeuoUrl,
                        HttpMethod.POST,httpEntity, CdeuoResultSaref.class);
                result = responseEntity.getBody();
            }

        } catch (Exception e) {

            }
        return result;

    }
        public LibelleUoResultSaref getLibelleUoData(String cdeuo){
            String token = ssoApplicationService.getWessidToken();
            HttpHeaders headers = new HttpHeaders();
            headers.add("wessoAuthcookie",token);
            LibelleUoResultSaref result = null;
            try {
                String libelleUoRequest = filesService.getFileContent("request/delLibelleUoRequest.json");
                if (libelleUoRequest!= null) {
                    String libelleUoRequestfinal = libelleUoRequest.replace("%cdeuo%", cdeuo );
                    HttpEntity httpEntity = new HttpEntity(libelleUoRequestfinal, headers);
                    ResponseEntity<LibelleUoResultSaref> responseEntity = restTemplate.exchange(requestLibuoUrl,
                            HttpMethod.POST,httpEntity, LibelleUoResultSaref.class);
                    result = responseEntity.getBody();
                }

            } catch (Exception e) {

            }
            return result;
        }

        public EtablissementResultSaref getEtablissementData(String codeEtab){
            String token = ssoApplicationService.getWessidToken();
            HttpHeaders headers = new HttpHeaders();
            headers.add("wessoAuthcookie",token);
            EtablissementResultSaref result = null;
            try{
                String etablissementRequest = filesService.getFileContent("request/delEtablissementRequest.json");
                if (etablissementRequest != null){
                    String etablissementRequestFinal = etablissementRequest.replace("%codeEtab%", codeEtab);
                    HttpEntity httpEntity = new HttpEntity(etablissementRequestFinal, headers);
                    ResponseEntity<EtablissementResultSaref> responseEntity = restTemplate.exchange(requestEtabUrl,
                            HttpMethod.POST,httpEntity, EtablissementResultSaref.class);
                    result = responseEntity.getBody();

                }

            }catch (Exception e) {

            }
            return result;
        }

    public AdresseEtabResultSaref getAdresseEtabData(String codeEtab){
        String token = ssoApplicationService.getWessidToken();
        HttpHeaders headers = new HttpHeaders();
        headers.add("wessoAuthcookie",token);

        AdresseEtabResultSaref result = null;
        try{
            String adresseEtabRequest = filesService.getFileContent("request/delAdresseEtabRequest.json");
            if (adresseEtabRequest != null){
                String adresseEtabRequestFinal = adresseEtabRequest.replace("%codeEtab%", codeEtab);
                HttpEntity httpEntity = new HttpEntity(adresseEtabRequestFinal, headers);
                ResponseEntity<AdresseEtabResultSaref> responseEntity = restTemplate.exchange(requestAddEtabUrl,
                        HttpMethod.POST,httpEntity, AdresseEtabResultSaref.class);
                result = responseEntity.getBody();

            }

        }catch (Exception e) {

        }
        return result;

    }

    public Manager getManagerData(String respon){

        String resquest2 ="?idType=numPersonne&fields=civilite,nom,prenom,courriel,telephone";

        String resquestFinal = requestPersonUrl + respon + resquest2;

        String token = ssoApplicationService.getWessidToken();
        HttpHeaders headers = new HttpHeaders();
        headers.add("wessoAuthcookie",token);

        HttpEntity httpEntity = new HttpEntity(headers);
        ResponseEntity<Manager> result = restTemplate.exchange(resquestFinal,
                HttpMethod.GET,httpEntity, Manager.class);
        return result.getBody();


    }

}






