package controller;

import com.tourguide.dao.UserDao;
import com.tourguide.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import service.BaseTest;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Created by liutongbin on 2017/3/25.
 */
public class TestHello extends BaseTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private UserDao userDao;

    @Test
    public void insert() {
        User user = new User();
        user.setMobile("18755552222");
//        user.set
//        System.out.println(userDao.create());
    }

    @Test
    public void findUser() {
        System.out.println("result=" + userDao.selectById("1"));
    }

    @Test
    public void selectOne() {
        System.out.println("tt=result=" + userDao.findByMobile("15955552919"));
    }

    @Test
    public void update() {
        User user = userDao.findByMobile("15955552919");
        user.setMobile("15844443333");
        System.out.println("user=" + user);
        System.out.println("update result=" + userDao.update(user));
    }

    @Test
    public void greeting() {
        try {
            mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk()).andExpect(content().string(equalTo("greeting from springboot.")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
