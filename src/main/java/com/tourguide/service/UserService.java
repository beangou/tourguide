package com.tourguide.service;

import com.tourguide.common.TourguideException;
import com.tourguide.common.ro.UserCreateRo;
import com.tourguide.common.ro.UserUpdateRo;
import com.tourguide.common.vo.UserVo;
import com.tourguide.dao.UserDao;
import com.tourguide.entity.User;
import com.tourguide.utils.MD5;
import com.tourguide.utils.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liutongbin on 2017/4/5.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public boolean create(UserCreateRo ro) {
        String salt = StringUtils.getSixNumStr();
        User user = new User();
        user.setId(StringUtils.getUUID());
        user.setMobile(ro.getMobile());
        user.setPassword(MD5.getMD5Code(ro.getPassword() + salt));
        user.setSalt(salt);
        return userDao.create(user) == 1;
    }

    public UserVo login(String mobile, String password) {
        User user = userDao.findByMobile(mobile);
        if (user == null) {
            throw new TourguideException("不存在该用户");
        }
        if (!user.getPassword().equals(MD5.getMD5Code(password + user.getSalt()))) {
            throw new TourguideException("用户名或密码错误");
        }
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(user, userVo);
        return userVo;
    }


    public Boolean update(UserUpdateRo userUpdateRo) {
        User user = new User();
        BeanUtils.copyProperties(userUpdateRo, user);
        return 1 == userDao.update(user);
    }
}
