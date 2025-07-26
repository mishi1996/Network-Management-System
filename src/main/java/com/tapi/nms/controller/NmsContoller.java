package com.tapi.nms.controller;

import com.tapi.nms.service.TapiConnectivityService;
import com.tapi.nms.service.TapiTopologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController("/nms")
public class NmsContoller {

    @Autowired
    private TapiConnectivityService tapiConnectivityService;

    @Autowired
    private TapiTopologyService topologyService;

    @GetMapping("/topology")
    public ResponseEntity<String> getTopology(){
        return  ResponseEntity.ok(topologyService.fetch());
    }

    public  ResponseEntity<String> createConectivity(Map<String,Object>payloads){
        return ResponseEntity.ok(tapiConnectivityService.create(payloads));
    }
}
