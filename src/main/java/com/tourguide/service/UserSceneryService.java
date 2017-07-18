package com.tourguide.service;

import com.tourguide.dao.SceneryDao;
import com.tourguide.dao.UserSceneryDao;
import com.tourguide.entity.Scenery;
import com.tourguide.entity.UserScenery;
import com.tourguide.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by liutongbin on 2017/7/9.
 */
@Service
public class UserSceneryService {

    @Autowired
    private UserSceneryDao userSceneryDao;

    @Autowired
    private SceneryDao sceneryDao;

    public Boolean save(String userId, String sceneryId) {
        UserScenery userScenery = new UserScenery();
        userScenery.setId(StringUtils.getUUID());
        userScenery.setUserId(userId);
        userScenery.setSceneryId(sceneryId);
        return userSceneryDao.insert(userScenery) == 1;
    }

    public List<Scenery> list(String userId, int page, int size) {
        List<UserScenery> userSceneryList = userSceneryDao.findByPage(userId, page, size);
        List<String> sceneryIdList = userSceneryList.stream().map(e -> e.getSceneryId()).collect(Collectors.toList());
        return sceneryDao.findByIds(sceneryIdList);
    }

    public Boolean remove(String userId, String sceneryId) {
        return userSceneryDao.delete(userId, sceneryId) > 0;
    }

}
