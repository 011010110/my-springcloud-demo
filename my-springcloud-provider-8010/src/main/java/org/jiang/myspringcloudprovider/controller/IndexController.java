package org.jiang.myspringcloudprovider.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Value("${server.port}")
    private String port;

    @GetMapping("hello")
    public String hello(@RequestParam("name")String name){
        logger.info("provider IndexController hello() 方法调用");
        return "hello "+name+",I'm "+port;
    }
}
