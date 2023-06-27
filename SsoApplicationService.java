package fr.sacem.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class SsoApplicationService {

    @Value("${wessid.user}")
    private String wessidUser;

    @Value("${wessid.base.url}")
    private String wessidBaseUrl;

    @Value("${wessid.password}")
    private String wessidPassword ;


    @Autowired
    RestTemplate restTemplate;


    public String getWessidToken(){
        String token = null;
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
            body.add("pwd",wessidPassword);
            HttpEntity httpEntity = new HttpEntity(body, headers);
            String wessidUrl = wessidBaseUrl+wessidUser;
            token = restTemplate.postForObject(wessidUrl, httpEntity, String.class);

        }catch (Exception e){

        }
        return token;
    }

}

