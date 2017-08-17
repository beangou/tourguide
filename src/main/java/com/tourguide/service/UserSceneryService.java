package com.tourguide.service;

import com.tourguide.common.vo.SceneryVo;
import com.tourguide.dao.SceneryDao;
import com.tourguide.dao.UserSceneryDao;
import com.tourguide.entity.UserScenery;
import com.tourguide.utils.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
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

    public List<SceneryVo> list(String userId, int page, int size) {
        List<SceneryVo> result = new ArrayList<>();
        List<UserScenery> userSceneryList = userSceneryDao.findByPage(userId, page, size);
        List<String> sceneryIdList = userSceneryList.stream().map(e -> e.getSceneryId()).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(sceneryIdList)) {
            return result;
        }
        sceneryDao.findByIds(sceneryIdList).forEach(e -> {
            SceneryVo sceneryVo = new SceneryVo();
            BeanUtils.copyProperties(e, sceneryVo);
            result.add(sceneryVo);
        });
        return result;
    }

    public Boolean remove(String userId, String sceneryId) {
        return userSceneryDao.delete(userId, sceneryId) > 0;
    }

}
