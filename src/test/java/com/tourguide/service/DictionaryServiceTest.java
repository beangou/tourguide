package com.tourguide.service;

import com.alibaba.druid.support.json.JSONUtils;
import com.tourguide.common.enums.DictionaryTypeEnum;
import com.tourguide.common.ro.backend.SceneryListRo;
import com.tourguide.entity.Dictionary;
import com.tourguide.mapper.DictionaryMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import service.BaseTest;

import static org.junit.Assert.*;

/**
 * Created by liutongbin on 2017/7/16.
 */
public class DictionaryServiceTest extends BaseTest {

    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private DictionaryMapper dictionaryMapper;

    @Test
    public void findByType() throws Exception {
//        SceneryListRo sceneryListRo = new SceneryListRo();
//        sceneryListRo.setType();
//        System.out.println("list=" + dictionaryService.findByType(sceneryListRo));
    }

    @Test
    public void save() {
        Dictionary dictionary = new Dictionary();
        dictionary.setCode("000001");
        dictionary.setType(DictionaryTypeEnum.ADDRESS.getType());
        dictionary.setValue("安庆");
        dictionaryMapper.insert(dictionary);
    }

}