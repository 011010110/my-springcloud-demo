package org.jiang.myspringcloudconsumer.service.impl;

import org.jiang.myspringcloudconsumer.service.FeignHelloService;
import org.springframework.stereotype.Component;

@Component
public class FeignHelloHystrixErrorService implements FeignHelloService {
    @Override
    public String hello(String name) {
        return name+" ,this is FeignHelloHystrixErrorService";
    }
}
