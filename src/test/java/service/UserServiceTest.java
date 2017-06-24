package service;

import com.tourguide.common.ro.UserCreateRo;
import com.tourguide.common.ro.UserUpdateRo;
import com.tourguide.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by liutongbin on 2017/4/23.
 */
public class UserServiceTest extends BaseTest {

    @Autowired
    private UserService userService;

    @Test
    public void create() {
        UserCreateRo ro = new UserCreateRo();
        ro.setMobile("15322221199");
        ro.setPassword("222222");
        System.out.println("result=" + userService.create(ro));
    }

    @Test
    public void login() {
        String mobile = "15322221199";
        String password = "222222";
        System.out.println("result=" + userService.login(mobile, password));
    }

    @Test
    public void update() {
        UserUpdateRo ro = new UserUpdateRo();
        ro.setAddress("");
        ro.setNickname("小彬");
        ro.setId("0982f0bfa87444eeac272540cea5f49b");
        ro.setMobile("15955552919");
        System.out.println("result=" + userService.update(ro));
    }

}
