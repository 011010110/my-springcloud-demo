package org.jiang.myspringcloudconsumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.jiang.myspringcloudconsumer.service.FeignHelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class IndexController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private FeignHelloService feignHelloService;

    @Value("${foo}")
    private String configFoo;

    @GetMapping("baidu")
    public void baidu(HttpServletResponse response){
        String url = "https://www.baidu.com";
        String result = restTemplate.getForObject(url, String.class);
        response.setContentType("text/html");
        response.setStatus(200);
        try {
            response.getWriter().print(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("hello")
    @HystrixCommand(fallbackMethod = "hystrixError")
    public String hello(String name){
        logger.info("Controller hello() 方法调用");
        String url ="http://springcloud-eureka-client-provider/hello?name="+name;
        String result = restTemplate.getForObject(url, String.class);
        return result;
    }

    public String hystrixError(String name){
        return "hystrixError happen ,"+name;
    }

    @GetMapping("feignHello")
    public String feignHello(String name){
        logger.info("Controller feignHello() 方法调用");
        return feignHelloService.hello(configFoo+"----feign."+name);
    }


}
