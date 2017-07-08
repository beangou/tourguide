package com.tourguide.utils;

import java.util.Random;
import java.util.UUID;

/**
 * Created by liutongbin on 2017/4/5.
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {

    /**
     * 获取6位随机数
     * @return
     */
    public static String getSixNumStr() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
    }

}
