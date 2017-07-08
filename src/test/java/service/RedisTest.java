package service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * Created by liutongbin on 2017/7/8.
 */
public class RedisTest extends BaseTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void get() {
        System.out.println("result=" + stringRedisTemplate.opsForValue().get("first_one"));
    }

}
