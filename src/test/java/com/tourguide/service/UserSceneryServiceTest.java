package com.tourguide.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import service.BaseTest;

import static org.junit.Assert.*;

/**
 * Created by liutongbin on 2017/7/18.
 */
public class UserSceneryServiceTest extends BaseTest {

    @Autowired
    private UserSceneryService userSceneryService;

    @Test
    public void save() throws Exception {
//        userSceneryService.save("0982f0bfa87444eeac272540cea5f49b", "387413ec4df64fb0ad6711ea11b1c7b8");
        userSceneryService.save("0982f0bfa87444eeac272540cea5f49b", "1e59cda78af14f96add58afaf04f288f");
    }

    @Test
    public void list() throws Exception {
        System.out.println("list=" + userSceneryService.list("0982f0bfa87444eeac272540cea5f49b", 0, 10));
    }

    @Test
    public void remove() throws Exception {
        System.out.println("result=" + userSceneryService.remove("0982f0bfa87444eeac272540cea5f49b", "1e59cda78af14f96add58afaf04f288f"));
    }

}