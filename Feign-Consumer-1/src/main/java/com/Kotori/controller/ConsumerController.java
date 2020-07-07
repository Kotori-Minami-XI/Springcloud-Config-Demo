package com.Kotori.controller;

import com.Kotori.config.GitConfig;
import com.Kotori.service.EurekaFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
    @Autowired
    private EurekaFeignClient feignClient;

    @Autowired
    private GitConfig gitConfig;

    /***
     *
     * @return
     */
    @RequestMapping("/getConfig")
    public String getConfig() {
        return gitConfig.toString();
    }

}
