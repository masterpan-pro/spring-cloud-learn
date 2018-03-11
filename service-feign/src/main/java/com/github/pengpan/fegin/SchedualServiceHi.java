package com.github.pengpan.fegin;

import com.github.pengpan.hystric.SchedualServiceHiHystric;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Feign接口
 *
 * @author pengpan
 */
@FeignClient(value = "eureka-server-hi", fallback = SchedualServiceHiHystric.class)
public interface SchedualServiceHi {

    /**
     * 调用服务提供者的hi
     *
     * @param name 姓名
     * @return string
     */
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
