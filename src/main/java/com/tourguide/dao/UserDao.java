package com.tourguide.dao;

import com.tourguide.entity.User;
import com.tourguide.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created by liutongbin on 2017/4/3.
 */
@Component
public class UserDao {

    @Autowired
    private UserMapper userMapper;

//    private final SqlSession sqlSession;
//
//    public UserDao(SqlSession sqlSession) {
//        this.sqlSession = sqlSession;
//    }

    public User selectById(int id) {
        return this.userMapper.selectByPrimaryKey(id);
//        return this.sqlSession.selectOne("selectByPrimaryKey", id);
    }

    public int update() {
        return userMapper.updateByPrimaryKeySelective(new User());
    }

//    public User findById(int id) {
//        return userMapper.selectByPrimaryKey(id);
//    }

}
