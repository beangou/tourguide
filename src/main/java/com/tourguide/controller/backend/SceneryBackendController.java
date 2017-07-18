package com.tourguide.controller.backend;

import com.tourguide.common.Result;
import com.tourguide.common.ro.PageParamsRo;
import com.tourguide.common.ro.backend.SceneryAddRo;
import com.tourguide.common.ro.backend.SceneryDeleteRo;
import com.tourguide.common.ro.backend.SceneryDetailRo;
import com.tourguide.common.ro.backend.SceneryUpdateRo;
import com.tourguide.controller.BaseController;
import com.tourguide.entity.Scenery;
import com.tourguide.service.SceneryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by liutongbin on 2017/7/16.
 */
@RestController
@RequestMapping(value = "/backend/scenery")
public class SceneryBackendController extends BaseController {

    @Autowired
    private SceneryService sceneryService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Result<List<Scenery>> list(@RequestBody PageParamsRo pageParamsRo) {
        return Result.success(sceneryService.findByPage(pageParamsRo));
    }

    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public Result<Scenery> detail(@RequestBody SceneryDetailRo sceneryDetailRo) {
        return Result.success(sceneryService.findById(sceneryDetailRo.getId()));
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<Boolean> add(@RequestBody SceneryAddRo sceneryAddRo) {
        return Result.success(sceneryService.add(sceneryAddRo));
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<Boolean> update(@RequestBody SceneryUpdateRo sceneryUpdateRo) {
        return Result.success(sceneryService.update(sceneryUpdateRo));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result<Boolean> delete(@RequestBody SceneryDeleteRo sceneryDeleteRo) {
        return Result.success(sceneryService.delete(sceneryDeleteRo));
    }

}
