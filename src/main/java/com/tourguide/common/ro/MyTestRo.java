package com.tourguide.common.ro;

import com.tourguide.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by liutongbin on 2017/8/21.
 */
@Getter
@Setter
public class MyTestRo extends BaseEntity {

    private String name;

    private int age;

    private MyTestSubRo myTestSubRo;

}
