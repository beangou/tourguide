package com.tourguide.dao;

import com.tourguide.entity.Scenery;
import com.tourguide.mapper.SceneryMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by liutongbin on 2017/7/9.
 */
@Component
public class SceneryDao {

    @Autowired
    private SceneryMapper sceneryMapper;

    public int insert(Scenery scenery) {
        if (scenery == null) {
            return 0;
        }
        Date now = new Date();
        scenery.setCreated(now);
        scenery.setUpdated(now);
        return sceneryMapper.insert(scenery);
    }

    public int update(Scenery scenery) {
        if (scenery == null) {
            return 0;
        }
        scenery.setUpdated(new Date());
        return sceneryMapper.updateByPrimaryKeySelective(scenery);
    }

    public List<Scenery> findByPage(int page, int size) {
        // 从第一页开始
        RowBounds rowBounds = new RowBounds((page-1)*size, size);
        return sceneryMapper.selectByExampleAndRowBounds(null, rowBounds);
    }

    public Scenery findById(String id) {
        return sceneryMapper.selectByPrimaryKey(id);
    }
}
