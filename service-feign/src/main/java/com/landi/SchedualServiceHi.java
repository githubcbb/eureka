package com.landi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by cbb on 2018/7/18.
 */
@FeignClient(value = "service-hi")//通过@ FeignClient（“服务名”），来指定调用哪个服务
public interface SchedualServiceHi {

    @GetMapping(value = "/hi")//XXX服务的的“/hi”接口
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
