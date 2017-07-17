package com.tourguide.controller.backend;

import com.tourguide.common.Result;
import com.tourguide.common.TourguideException;
import com.tourguide.common.ro.backend.LoginRo;
import com.tourguide.common.vo.BackendUserVo;
import com.tourguide.common.vo.UserVo;
import com.tourguide.controller.BaseController;
import com.tourguide.utils.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by liutongbin on 2017/7/10.
 */
@RestController
@RequestMapping("/backend")
public class LoginBackendController extends BaseController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result<String> login(@RequestBody LoginRo loginRo, HttpServletRequest request, HttpServletResponse response) {
        logger.info("loginRo={}", loginRo);
        // TODO 暂时后台登录账号写死
        if ("admin".equals(loginRo.getEmail()) && "password".equals(loginRo.getPassword())) {
            saveUserSession(request, response, "admin");
            return Result.success(loginRo.getEmail());
        } else {
            return Result.failure("用户名或者密码不正确");
        }
    }

    @RequestMapping(value = "/isAuthenticated", method = RequestMethod.GET)
    public Result<Boolean> isAuthenticated(HttpServletRequest request) {
        try {
            String userSessionId = getUserSessionId(request);
            if (StringUtils.isBlank(userSessionId)) {
                return Result.failure("请重新登录");
            }
            return Result.success(Boolean.TRUE);
        } catch (TourguideException e) {
            return Result.failure(e.getMessage());
        } catch (Exception e) {
            return Result.failure("请重新登录");
        }
    }

}
