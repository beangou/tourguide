package com.tourguide.service;

import com.tourguide.common.ro.PageParamsRo;
import com.tourguide.entity.Scenery;
import com.tourguide.utils.StringUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import service.BaseTest;

import static org.junit.Assert.*;

/**
 * Created by liutongbin on 2017/7/9.
 */
public class SceneryServiceTest extends BaseTest {

    @Autowired
    private SceneryService sceneryService;

    @Test
    public void save() throws Exception {
        Scenery scenery = new Scenery();
        scenery.setId(StringUtils.getUUID());
        scenery.setName("白洋淀");
        scenery.setAddressCode("0000");
        scenery.setAddressValue("河北保定");
        scenery.setInternal(true);
        scenery.setDescription("白洋淀被誉为华北明珠，是小兵张嘎的故乡，。。。");
        sceneryService.save(scenery);
    }

    @Test
    public void find() {
        PageParamsRo pageParamsRo = new PageParamsRo();
        pageParamsRo.setPage(1);
        pageParamsRo.setSize(10);
        System.out.println("list=" + sceneryService.findByPage(pageParamsRo));
    }

}