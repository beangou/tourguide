package com.tourguide.dao;

import com.tourguide.entity.Scenery;
import com.tourguide.entity.UserScenery;
import com.tourguide.mapper.UserSceneryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by liutongbin on 2017/7/9.
 */
@Component
public class UserSceneryDao {

    @Autowired
    private UserSceneryMapper userSceneryMapper;

    public int insert(UserScenery userScenery) {
        if (userScenery == null) {
            return 0;
        }
        Date now = new Date();
        userScenery.setCreated(now);
        userScenery.setUpdated(now);
        return userSceneryMapper.insert(userScenery);
    }

    public int update(UserScenery userScenery) {
        if (userScenery == null) {
            return 0;
        }
        userScenery.setUpdated(new Date());
        return userSceneryMapper.updateByPrimaryKeySelective(userScenery);
    }

}
