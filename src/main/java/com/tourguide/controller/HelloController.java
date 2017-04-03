package com.tourguide.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liutongbin on 2017/3/25.
 */

@RestController
@EnableAutoConfiguration
@Api(value="helloController", description="Operations pertaining to products in Online Store")
public class HelloController {

    @ApiOperation(value = "View a list of available products", response = String.class)
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(int id) {
        return "greeting from springboot.";
    }

}
