package com.tourguide.controller;

import com.tourguide.common.Result;
import com.tourguide.common.TourguideException;
import com.tourguide.common.ro.ExistedRo;
import com.tourguide.common.ro.LoginRo;
import com.tourguide.common.ro.UserCreateRo;
import com.tourguide.common.ro.UserUpdateRo;
import com.tourguide.common.vo.UserDetailVo;
import com.tourguide.common.vo.UserVo;
import com.tourguide.entity.User;
import com.tourguide.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by liutongbin on 2017/4/5.
 */

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> register(@RequestBody UserCreateRo userCreateRo) {
        if (StringUtils.isEmpty(userCreateRo.getMobile())) {
            return Result.paramError("mobile不能为空");
        }
        if (StringUtils.isEmpty(userCreateRo.getPassword())) {
            return Result.paramError("password不能为空");
        }
        if (userService.existed(userCreateRo.getMobile())) {
            return Result.paramError("该手机号已经注册");
        }
        try {
            return Result.success(userService.create(userCreateRo));
        } catch (TourguideException e) {
            logger.error("TourguideException：", e);
            return Result.failure(e.getMessage());
        } catch (Exception e) {
            logger.error("未知异常：", e);
            return Result.exception();
        }

    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Result<UserVo> login(@RequestBody LoginRo loginRo, HttpServletRequest request, HttpServletResponse response) {
        if (StringUtils.isEmpty(loginRo.getMobile())) {
            return Result.paramError("mobile不能为空");
        }
        if (StringUtils.isEmpty(loginRo.getPassword())) {
            return Result.paramError("password不能为空");
        }
        if (!userService.existed(loginRo.getMobile())) {
            return Result.paramError("该手机号不存在");
        }
        try {
            UserVo userVo = userService.login(loginRo);
            // 将登录信息存入redis
            saveUserSession(request, response, userVo);
            return Result.success(userVo);
        } catch (TourguideException e) {
            logger.error("发生业务异常：", e);
            return Result.failure("登录失败:用户名或者密码错误");
        } catch (Exception e) {
            logger.error("发生未知异常：", e);
            return Result.failure("登录失败:发生未知异常");
        }
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    @ResponseBody
    public Result<UserDetailVo> detail(String token) {
        return Result.success(userService.detail(getUserId(token)));
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> update(@RequestBody UserUpdateRo userUpdateRo) {
        return Result.success(userService.update(userUpdateRo, getUserId(userUpdateRo.getToken())));
    }

    /**
     * 校验是否存在该用户
     * @param existedRo
     * @return
     */
    @RequestMapping(value = "/existed", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> existed(@RequestBody ExistedRo existedRo) {
        if (StringUtils.isEmpty(existedRo.getMobile())) {
            return Result.paramError("mobile不能为空");
        }
        return Result.success(userService.existed(existedRo.getMobile()));
    }
}
