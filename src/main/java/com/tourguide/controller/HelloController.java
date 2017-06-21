package com.tourguide.controller;

import com.alibaba.druid.support.json.JSONUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * Created by liutongbin on 2017/3/25.
 */

@RestController
@EnableAutoConfiguration
@Api(value="helloController", description="Operations pertaining to products in Online Store")
public class HelloController {

    private int num;

    @ApiOperation(value = "View a list of available products", response = String.class)
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public int index(HttpServletRequest request, HttpServletResponse response) {
        num++;
        System.out.println("num=" + num);
        String sessionId = null;
        System.out.println("cookies=" + request.getCookies());
        if (request.getCookies() != null && request.getCookies().length > 0) {
            for (Cookie cookie : request.getCookies()) {
                if ("sessionId".equals(cookie.getName())) {
                    sessionId = cookie.getValue();
                    break;
                }
            }
        }

        if (StringUtils.isBlank(sessionId)) {
            // 如果不存在，则服务端生成sessionId
            Cookie cookie = new Cookie("sessionId", UUID.randomUUID().toString());
            response.addCookie(cookie);
        }
        return num;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "hello";
    }

}
