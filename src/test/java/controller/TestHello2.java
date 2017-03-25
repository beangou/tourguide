package controller;

import com.tourguide.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by liutongbin on 2017/3/25.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestHello2 {

    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Before
    public void setUp() {
        try {
            System.out.println("port=" + port);
            this.base = new URL("http://localhost:" + port + "/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void hello() {
        ResponseEntity<String> entity = testRestTemplate.getForEntity(base.toString(), String.class);
        System.out.println("result=" + entity.getBody());
    }

}
