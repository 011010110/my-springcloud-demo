package org.jiang.myspringcloudconsumer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class MySpringcloudConsumer8020ApplicationTests {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    void contextLoads() {
        String url = "https://www.baidu.com";
        String result = restTemplate.getForObject(url, String.class);
        System.out.printf(result);
    }

}
