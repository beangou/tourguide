package com.tourguide.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liutongbin on 2017/3/25.
 */

@RestController
@EnableAutoConfiguration
public class HelloController {

    @RequestMapping(value = "/")
    public String index() {
        return "greeting from springboot.";
    }

}
