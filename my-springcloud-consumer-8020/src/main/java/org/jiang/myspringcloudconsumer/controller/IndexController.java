package org.jiang.myspringcloudconsumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.jiang.myspringcloudconsumer.service.FeignHelloService;
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
        String url ="http://springcloud-eureka-client-provider/hello?name="+name;
        String result = restTemplate.getForObject(url, String.class);
        return result;
    }

    public String hystrixError(String name){
        return "hystrixError happen ,"+name;
    }

    @GetMapping("feignHello")
    public String feignHello(String name){
        return feignHelloService.hello(configFoo+"----feign."+name);
    }


}
