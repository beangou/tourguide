package com.tourguide.common.enums;

import lombok.Getter;
import lombok.Setter;

/**
 * 字典类型枚举
 * Created by liutongbin on 2017/7/16.
 */
@Getter
public enum DictionaryTypeEnum {

    ADDRESS(0, "地址字典类型");

    DictionaryTypeEnum(int type, String name) {
        this.type = type;
        this.name = name;
    }

    private int type;

    private String name;

}
