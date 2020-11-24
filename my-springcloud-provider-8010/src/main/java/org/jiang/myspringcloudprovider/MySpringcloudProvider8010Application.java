package org.jiang.myspringcloudprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MySpringcloudProvider8010Application {

    public static void main(String[] args) {
        SpringApplication.run(MySpringcloudProvider8010Application.class, args);
    }

}
