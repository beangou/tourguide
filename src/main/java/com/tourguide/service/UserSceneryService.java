package com.tourguide.service;

import com.tourguide.dao.UserSceneryDao;
import com.tourguide.entity.UserScenery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liutongbin on 2017/7/9.
 */
@Service
public class UserSceneryService {

    @Autowired
    private UserSceneryDao userSceneryDao;

    public Boolean save(UserScenery userScenery) {
        return userSceneryDao.insert(userScenery) == 1;
    }

}
