package com.tourguide.service;

import com.tourguide.common.TourguideException;
import com.tourguide.common.vo.UserVo;
import com.tourguide.utils.JsonUtil;
import com.tourguide.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by liutongbin on 2017/7/8.
 */
@Service
public class RedisService {

    private static final String USER_SESSION_PREFIX = "USER_SESSION:";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void saveUserSession(String userSessionId, Object obj) {
        if (StringUtils.isBlank(userSessionId)) {
            throw new TourguideException("userSessionId不能为空");
        }
        // 登录用户不需要限制登录时长，除非客户端清掉cookie
        stringRedisTemplate.opsForValue().set(USER_SESSION_PREFIX + userSessionId, JsonUtil.toJsonString(obj));
    }

    public UserVo getUserSession(String userSessionId) {
        if (StringUtils.isBlank(userSessionId)) {
            throw new TourguideException("userSessionId不能为空");
        }
        String userVoJson = stringRedisTemplate.opsForValue().get(USER_SESSION_PREFIX + userSessionId);
        if (StringUtils.isBlank(userVoJson)) {
            throw new TourguideException("请重新登录");
        }
        return JsonUtil.fromJsonString(userVoJson, UserVo.class);
    }
}
