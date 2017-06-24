package com.tourguide.controller;

import com.tourguide.common.Result;
import com.tourguide.common.ro.UserCreateRo;
import com.tourguide.common.ro.UserUpdateRo;
import com.tourguide.common.vo.UserVo;
import com.tourguide.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by liutongbin on 2017/4/5.
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> create(@RequestBody UserCreateRo userCreateRo) {
        if (StringUtils.isEmpty(userCreateRo.getMobile())) {
            return Result.paramError("mobile不能为空");
        }
        if (StringUtils.isEmpty(userCreateRo.getPassword())) {
            return Result.paramError("password不能为空");
        }
        return Result.success(userService.create(userCreateRo));
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Result<UserVo> login(String mobile, String password) {
        if (StringUtils.isEmpty(mobile)) {
            return Result.paramError("mobile不能为空");
        }
        if (StringUtils.isEmpty(password)) {
            return Result.paramError("password不能为空");
        }
        return Result.success(userService.login(mobile, password));
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> update(@RequestBody UserUpdateRo userUpdateRo) {
        if (StringUtils.isEmpty(userUpdateRo.getId())) {
            return Result.paramError("userId不能为空");
        }
        return Result.success(userService.update(userUpdateRo));
    }
}
