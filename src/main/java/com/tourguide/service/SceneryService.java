package com.tourguide.service;

import com.tourguide.common.ro.PageParamsRo;
import com.tourguide.common.ro.backend.SceneryAddRo;
import com.tourguide.dao.SceneryDao;
import com.tourguide.entity.Scenery;
import com.tourguide.utils.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by liutongbin on 2017/7/9.
 */
@Service
public class SceneryService {

    @Autowired
    private SceneryDao sceneryDao;

    public Boolean save(Scenery scenery) {
        return sceneryDao.insert(scenery) == 1;
    }

    public List<Scenery> findByPage(PageParamsRo page) {
        return sceneryDao.findByPage(page.getPage(), page.getSize());
    }

    public Scenery findById(String id) {
        return sceneryDao.findById(id);
    }

    public Boolean add(SceneryAddRo sceneryAddRo) {
        Date now = new Date();
        Scenery scenery = new Scenery();
        BeanUtils.copyProperties(sceneryAddRo, scenery);
        scenery.setId(StringUtils.getUUID());
        scenery.setCreated(now);
        scenery.setUpdated(now);
        return sceneryDao.insert(scenery) == 1;
    }
}
