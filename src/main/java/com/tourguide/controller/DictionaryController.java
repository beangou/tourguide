package com.tourguide.controller;

import com.tourguide.common.Page;
import com.tourguide.common.Result;
import com.tourguide.common.ro.backend.DictionaryListRo;
import com.tourguide.entity.Dictionary;
import com.tourguide.service.DictionaryService;
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
@RequestMapping("/dictionary")
public class DictionaryController extends BaseController {

    @Autowired
    private DictionaryService dictionaryService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Result<List<Dictionary>> list(@RequestBody DictionaryListRo dictionaryListRo) {
        return Result.success(dictionaryService.findByType(dictionaryListRo));
    }

}
