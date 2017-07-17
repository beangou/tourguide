package com.tourguide.controller;

import com.tourguide.entity.Dictionary;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by liutongbin on 2017/7/16.
 */
@RestController
@RequestMapping("/dictionary")
public class DictionaryController extends BaseController {

    public List<Dictionary> list() {
        return null;
    }

}
