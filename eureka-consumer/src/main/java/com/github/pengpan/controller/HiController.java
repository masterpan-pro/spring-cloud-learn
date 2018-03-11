package com.github.pengpan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author pengpan
 */
@RestController
public class HiController {

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/hi")
    public String dc() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-server-hi");
        String url = "http://" + serviceInstance.getServiceId() + "/hi?name=admin";
        System.out.println(url);
        return restTemplate.getForObject(url, String.class);
    }
}
