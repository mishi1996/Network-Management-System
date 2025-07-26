package com.tapi.nms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TapiTopologyService {

    @Value("restconf.base-url")
    public String baseUrl;

    @Autowired
    private RestConfClient restConfClient;

    public String fetch(){
        return restConfClient.get(baseUrl+"/tapi-topology:topology-context");
    }
}
