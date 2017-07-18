package com.tourguide.dao;

import com.tourguide.entity.Dictionary;
import com.tourguide.entity.Scenery;
import com.tourguide.entity.UserScenery;
import com.tourguide.mapper.UserSceneryMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * Created by liutongbin on 2017/7/9.
 */
@Component
public class UserSceneryDao {

    @Autowired
    private UserSceneryMapper userSceneryMapper;

    public List<UserScenery> findByPage(String userId, int page, int size) {
        Example example = new Example(UserScenery.class);
        example.createCriteria().andEqualTo("userId", userId).andIsNull("deleted");
        RowBounds rowBounds = new RowBounds((page-1)*size, size);
        return userSceneryMapper.selectByExampleAndRowBounds(example, rowBounds);
    }

    public int insert(UserScenery userScenery) {
        if (userScenery == null) {
            return 0;
        }
        Date now = new Date();
        userScenery.setCreated(now);
        userScenery.setUpdated(now);
        return userSceneryMapper.insert(userScenery);
    }

    /**
     * 更新deleted字段
     * @param userId
     * @param sceneryId
     * @return
     */
    public int delete(String userId, String sceneryId) {
        Example example = new Example(UserScenery.class);
        example.createCriteria().andEqualTo("userId", userId).andEqualTo("sceneryId", sceneryId);
        UserScenery userScenery = new UserScenery();
        userScenery.setDeleted(new Date());
        return userSceneryMapper.updateByExampleSelective(userScenery, example);
    }

    public int update(UserScenery userScenery) {
        if (userScenery == null) {
            return 0;
        }
        userScenery.setUpdated(new Date());
        return userSceneryMapper.updateByPrimaryKeySelective(userScenery);
    }

}
