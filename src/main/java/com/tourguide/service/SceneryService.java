package com.tourguide.service;

import com.tourguide.common.Page;
import com.tourguide.common.ro.backend.SceneryAddRo;
import com.tourguide.common.ro.backend.SceneryDeleteRo;
import com.tourguide.common.ro.backend.SceneryUpdateRo;
import com.tourguide.common.ro.scenery.SceneryListRo;
import com.tourguide.common.ro.scenery.SceneryPageRo;
import com.tourguide.common.vo.SceneryVo;
import com.tourguide.dao.SceneryDao;
import com.tourguide.entity.Scenery;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public Page<Scenery> findByPage(SceneryPageRo sceneryPageRo) {
        List<Scenery> list = sceneryDao.findByPage(sceneryPageRo.getAddressCode(), sceneryPageRo.getPage(), sceneryPageRo.getSize());
        int totalCount = sceneryDao.count(null);
        Page<Scenery> sceneryPage = new Page<>();
        sceneryPage.setRecords(list);
        sceneryPage.setPage(sceneryPageRo.getPage());
        sceneryPage.setTotalCount(totalCount);
        return sceneryPage;
    }

    public List<SceneryVo> findAll(SceneryListRo sceneryListRo) {
        List<SceneryVo> result = new ArrayList<>();
        sceneryDao.findAll(sceneryListRo.getAddressCode(), sceneryListRo.getInternal()).forEach(e -> {
            SceneryVo sceneryVo = new SceneryVo();
            BeanUtils.copyProperties(e, sceneryVo);
            result.add(sceneryVo);
        });
        return result;
    }

    public Scenery findById(String id) {
        return sceneryDao.findById(id);
    }

    public Boolean add(SceneryAddRo sceneryAddRo) {
        Date now = new Date();
        Scenery scenery = new Scenery();
        BeanUtils.copyProperties(sceneryAddRo, scenery);
        scenery.setCreated(now);
        scenery.setUpdated(now);
        return sceneryDao.insert(scenery) == 1;
    }

    public Boolean delete(SceneryDeleteRo sceneryDeleteRo) {
        Scenery scenery = sceneryDao.findById(sceneryDeleteRo.getId());
        scenery.setDeleted(new Date());
        return sceneryDao.update(scenery) == 1;
    }

    public Boolean update(SceneryUpdateRo sceneryUpdateRo) {
        Scenery scenery = new Scenery();
        BeanUtils.copyProperties(sceneryUpdateRo, scenery);
        return sceneryDao.update(scenery) == 1;
    }
}
