package com.tapi.nms.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.HttpHeaders;
//import java.net.http.HttpHeaders;

@Component
public class RestConfClient {

   private final RestTemplate restTemplate;


    public RestConfClient(RestTemplateBuilder restTemplateBuilder,@Value("restconf.username")String username, @Value("restconf.password") String password){
       this.restTemplate=restTemplateBuilder.basicAuthentication(username, password).build();
    }
    public String get(String url){
        HttpHeaders headers= new HttpHeaders();
        headers.set("Accept","application/yang-data+json");
        HttpEntity<String> entity=new HttpEntity<>(headers);
        ResponseEntity<String>response=restTemplate.exchange(url, HttpMethod.GET,entity, String.class);
        return response.getBody();
    }

    public String post(String url, Object body){
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.valueOf("application/yang-data+json"));
        HttpEntity<String> entity=new HttpEntity<>(headers);
        ResponseEntity<String> response=restTemplate.exchange(url,HttpMethod.POST,entity, String.class);
        return response.getBody();
    }
}
