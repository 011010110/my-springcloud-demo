package org.jiang.myspringcloudzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@EnableEurekaClient
@EnableHystrix
@SpringBootApplication
public class MySpringcloudZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySpringcloudZuulApplication.class, args);
    }

}
