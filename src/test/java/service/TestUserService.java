package service;

import com.tourguide.common.ro.UserCreateRo;
import com.tourguide.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by liutongbin on 2017/4/23.
 */
public class TestUserService extends BaseTest {

    @Autowired
    private UserService userService;

    @Test
    public void see() {
        UserCreateRo ro = new UserCreateRo();
        ro.setMobile("15322221111");
        ro.setPassword("222222");
        System.out.println("result=" + userService.create(ro));
    }

}
