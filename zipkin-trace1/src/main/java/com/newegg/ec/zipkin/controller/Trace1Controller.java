package com.newegg.ec.zipkin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Trace1Controller {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    DiscoveryClient discoveryClient;


    @RequestMapping(value = "/trace1", method = RequestMethod.GET)
    public String trace(){
        System.out.println("service："+discoveryClient.getServices());
        logger.info("=======< trace 1 >======");
        return restTemplate.getForEntity("http://trace-2/trace2",String.class).getBody();
    }

}
