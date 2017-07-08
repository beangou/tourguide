package com.tourguide.utils;

import com.tourguide.common.vo.UserVo;
import org.junit.Test;
import springfox.documentation.spring.web.json.Json;

import static org.junit.Assert.*;

/**
 * Created by liutongbin on 2017/7/8.
 */
public class JsonUtilTest {
    @Test
    public void toJsonString() throws Exception {
        UserVo userVo = new UserVo();
        userVo.setNickname("88888");
        System.out.println("result=" + JsonUtil.toJsonString(userVo));
    }

    @Test
    public void fromJsonString() throws Exception {

    }

    @Test
    public void fromJsonString1() throws Exception {

    }

    @Test
    public void fromJsonString2() throws Exception {

    }

}