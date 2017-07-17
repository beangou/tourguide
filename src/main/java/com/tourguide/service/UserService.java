package com.tourguide.service;

import com.tourguide.common.TourguideException;
import com.tourguide.common.ro.LoginRo;
import com.tourguide.common.ro.UserCreateRo;
import com.tourguide.common.ro.UserUpdateRo;
import com.tourguide.common.vo.UserDetailVo;
import com.tourguide.common.vo.UserVo;
import com.tourguide.dao.UserDao;
import com.tourguide.entity.User;
import com.tourguide.utils.MD5;
import com.tourguide.utils.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.util.StringUtil;

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
        return userDao.insert(user) == 1;
    }

    public UserVo login(LoginRo loginRo) {
        User user = userDao.findByMobile(loginRo.getMobile());
        if (user == null) {
            throw new TourguideException("不存在该用户");
        }
        if (!user.getPassword().equals(MD5.getMD5Code(loginRo.getPassword() + user.getSalt()))) {
            throw new TourguideException("用户名或密码错误");
        }
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(user, userVo);
        return userVo;
    }


    public Boolean update(UserUpdateRo userUpdateRo, String id) {
        User user = new User();
        BeanUtils.copyProperties(userUpdateRo, user);
        user.setId(id);
        if (StringUtil.isNotEmpty(userUpdateRo.getPassword())) {
            String salt = StringUtils.getSixNumStr();
            user.setSalt(salt);
            user.setPassword(MD5.getMD5Code(userUpdateRo.getPassword() + salt));
        }
        return 1 == userDao.update(user);
    }

    public Boolean existed(String mobile) {
        return userDao.findByMobile(mobile) != null;
    }

    public UserDetailVo detail(String id) {
        User user = userDao.findById(id);
        UserDetailVo userDetailVo = new UserDetailVo();
        BeanUtils.copyProperties(user, userDetailVo);
        return userDetailVo;
    }
}
