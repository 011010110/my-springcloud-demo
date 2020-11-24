package org.jiang.myspringcloudconsumer.service;

import org.jiang.myspringcloudconsumer.config.FeignConfig;
import org.jiang.myspringcloudconsumer.service.impl.FeignHelloHystrixErrorService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 开启feignClient会使用Ribbon做负载均衡
 */
@FeignClient(name = "springcloud-eureka-client-provider",configuration = FeignConfig.class,fallback = FeignHelloHystrixErrorService.class,primary = true)
public interface FeignHelloService {

    @GetMapping("hello")
    String hello(@RequestParam("name") String name);


}
