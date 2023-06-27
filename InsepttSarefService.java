package fr.sacem.api.service;

import fr.sacem.api.model.InsepttResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class InsepttSarefService {

    @Autowired
    private SsoApplicationService ssoApplicationService;

    @Autowired
    private FilesService filesService;

    @Autowired
    RestTemplate restTemplate;

    @Value("${request.insptt.url}")
    private String resqestInspttUrl;

    public InsepttResultData getInspttData() {

        String token = ssoApplicationService.getWessidToken();

        HttpHeaders headers = new HttpHeaders();
        headers.add("wessoAuthcookie", token);
        InsepttResultData result = null;
        try {
            String citiesReqest = filesService.getFileContent("request/citiesRequest.json");
            if (citiesReqest != null) {
                HttpEntity httpEntity = new HttpEntity(citiesReqest, headers);
                ResponseEntity<InsepttResultData> responseEntity = restTemplate.exchange(resqestInspttUrl,
                        HttpMethod.POST, httpEntity, InsepttResultData.class);
                result = responseEntity.getBody();
            }


        } catch (Exception e) {

            e.printStackTrace();
        }
        return result;
    }



}
