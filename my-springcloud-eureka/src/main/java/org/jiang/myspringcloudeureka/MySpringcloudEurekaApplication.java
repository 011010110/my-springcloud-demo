package org.jiang.myspringcloudeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MySpringcloudEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySpringcloudEurekaApplication.class, args);
    }

}
