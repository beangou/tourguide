package com.tourguide.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 字典
 * Created by liutongbin on 2017/7/16.
 */
@Getter
@Setter
public class Dictionary extends BaseDbEntity {

    private int id;

    /**
     * 类型
     */
    private int type;

    private String code;

    private String value;

}
