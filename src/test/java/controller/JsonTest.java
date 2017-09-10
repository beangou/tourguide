package controller;

import com.tourguide.common.ro.MyTestRo;
import com.tourguide.common.ro.MyTestSubRo;
import com.tourguide.utils.JsonUtil;
import org.junit.Test;

/**
 * Created by liutongbin on 2017/8/21.
 */
public class JsonTest {

    @Test
    public void printJson() {
        MyTestRo myTestRo = new MyTestRo();
        myTestRo.setName("beangou");
        myTestRo.setAge(27);

        MyTestSubRo myTestSubRo = new MyTestSubRo();
        myTestSubRo.setCity("hangzhou");
        myTestSubRo.setAddress("余杭");
        myTestRo.setMyTestSubRo(myTestSubRo);

        System.out.println("result=" + JsonUtil.toJsonString(myTestRo));
    }

}
