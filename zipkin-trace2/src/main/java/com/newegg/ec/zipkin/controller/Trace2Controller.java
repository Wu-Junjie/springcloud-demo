package com.newegg.ec.zipkin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class Trace2Controller {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/trace2",method = RequestMethod.GET)
    public String trace2(HttpServletRequest request){
        logger.info("===<call trace-2, TraceId={}, SpanId={}>===",
                request.getHeader("X-B3-TraceId"), request.getHeader("X-B3-SpanId"));
        return "Trace";
    }
}

