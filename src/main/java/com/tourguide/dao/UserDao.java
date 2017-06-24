package com.tourguide.dao;

import com.tourguide.common.TourguideException;
import com.tourguide.entity.User;
import com.tourguide.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * Created by liutongbin on 2017/4/3.
 */
@Component
public class UserDao {

    @Autowired
    private UserMapper userMapper;

    public int create(User user) {
        if (user == null) {
            throw new TourguideException("user为null");
        }
        Date now = new Date();
        user.setCreateAt(now);
        user.setUpdateaAt(now);
        return userMapper.insertSelective(user);
    }

    public User findByMobile(String mobile) {
        if (StringUtils.isEmpty(mobile)) {
            throw new TourguideException("mobile不能为空");
        }
        User user = new User();
        user.setMobile(mobile);
        return userMapper.selectOne(user);
    }

    public User selectById(String id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public int update(User user) {
        user.setUpdateaAt(new Date());
        return userMapper.updateByPrimaryKeySelective(user);
    }

}
