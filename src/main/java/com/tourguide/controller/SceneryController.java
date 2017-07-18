package com.tourguide.controller;

import com.tourguide.common.Page;
import com.tourguide.common.Result;
import com.tourguide.common.ro.PageParamsRo;
import com.tourguide.common.ro.UserSceneryAddRo;
import com.tourguide.common.ro.backend.SceneryAddRo;
import com.tourguide.common.ro.backend.SceneryDetailRo;
import com.tourguide.common.ro.scenery.SceneryListRo;
import com.tourguide.entity.Scenery;
import com.tourguide.service.SceneryService;
import com.tourguide.service.UserSceneryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by liutongbin on 2017/7/17.
 */
@RestController
@RequestMapping("/scenery")
public class SceneryController extends BaseController {

    @Autowired
    private SceneryService sceneryService;

    @Autowired
    private UserSceneryService userSceneryService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Result<Page<Scenery>> listAll(@RequestBody SceneryListRo sceneryListRo) {
        return Result.success(sceneryService.findByPage(sceneryListRo));
    }

    @RequestMapping(value = "/user/list", method = RequestMethod.POST)
    public Result<List<Scenery>> listByUser(HttpServletRequest request, @RequestBody PageParamsRo pageParamsRo) {
        return Result.success(userSceneryService.list(getUserId(request), pageParamsRo.getPage(), pageParamsRo.getSize()));
    }

    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public Result<Scenery> detail(@RequestBody SceneryDetailRo sceneryDetailRo) {
        return Result.success(sceneryService.findById(sceneryDetailRo.getId()));
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public Result<Boolean> add(HttpServletRequest request, @RequestBody UserSceneryAddRo userSceneryAddRo) {
        String userId = getUserId(request);
        // 需和用户关联起来
        return Result.success(userSceneryService.save(userId, userSceneryAddRo.getSceneryId()));
    }

    @RequestMapping(value = "/user/remove", method = RequestMethod.POST)
    public Result<Boolean> remove(HttpServletRequest request, @RequestBody UserSceneryAddRo userSceneryAddRo) {
        String userId = getUserId(request);
        // 需和用户关联起来
        return Result.success(userSceneryService.remove(userId, userSceneryAddRo.getSceneryId()));
    }

}
