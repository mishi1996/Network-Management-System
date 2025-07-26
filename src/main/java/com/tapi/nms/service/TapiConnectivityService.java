package com.tapi.nms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TapiConnectivityService {

    @Value("restconf.rpc-url")
    public String baseUrl;

    @Autowired
    private RestConfClient restConfClient;

    public String create(Map<String,Object>payloads){
        return restConfClient.post(baseUrl+"/tapi-connectivity:create-connectivity-service",
                payloads);
    }
}
