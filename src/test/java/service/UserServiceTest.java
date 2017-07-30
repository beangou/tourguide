package service;

import com.tourguide.common.ro.LoginRo;
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
        ro.setMobile("15922228888");
        ro.setPassword("888888");
        System.out.println("result=" + userService.create(ro));
    }

    @Test
    public void login() {
        String mobile = "15922221188";
        String password = "888888";
        LoginRo loginRo = new LoginRo();
        loginRo.setPassword(password);
        loginRo.setMobile(mobile);
        System.out.println("result=" + userService.login(loginRo));
    }

    @Test
    public void update() {
        UserUpdateRo ro = new UserUpdateRo();
        ro.setAddress("");
        ro.setNickname("小彬");
//        ro.setId("0982f0bfa87444eeac272540cea5f49b");
        ro.setMobile("15955552919");
        System.out.println("result=" + userService.update(ro, "0982f0bfa87444eeac272540cea5f49b"));
    }

    @Test
    public void detail() {
        System.out.println("detail=" + userService.detail("53b16f26931648ee81b5748c6baa3023"));
    }

}
