package com.tourguide.controller;

import com.tourguide.common.TourguideException;
import com.tourguide.common.vo.UserVo;
import com.tourguide.entity.User;
import com.tourguide.service.RedisService;
import com.tourguide.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by liutongbin on 2017/7/1.
 */
public class BaseController {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    protected static final String USER_SESSION_ID = "USER_SESSION_ID";

    @Autowired
    protected RedisService redisService;

    /**
     * 获取当前登录用户
     * @return
     */
    protected UserVo getUserVo(HttpServletRequest request) {
        String userSessionId = getUserSessionId(request);
        if (StringUtils.isBlank(userSessionId)) {
            throw new TourguideException("请重新登录");
        }
        return redisService.getUserSession(userSessionId);
    }

    /**
     * 获取当前登录用户id
     * @return
     */
    protected String getUserId(HttpServletRequest request) {
        String userSessionId = getUserSessionId(request);
        if (StringUtils.isBlank(userSessionId)) {
            throw new TourguideException("请重新登录");
        }
        UserVo userVo = redisService.getUserSession(userSessionId);
        return userVo.getId();
    }

    protected String getUserSessionId(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0) {
            for (Cookie cookie : cookies) {
                if (USER_SESSION_ID.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    /**
     * 保存用户信息到redis
     * @param request
     * @param response
     * @param object
     */
    protected void saveUserSession(HttpServletRequest request, HttpServletResponse response, Object object) {
        String userSessionId = getUserSessionId(request);
        if (StringUtils.isBlank(userSessionId)) {
            userSessionId = StringUtils.getUUID();
            Cookie cookie = new Cookie(USER_SESSION_ID, userSessionId);
            response.addCookie(cookie);
        }
        redisService.saveUserSession(userSessionId, object);
    }

}
