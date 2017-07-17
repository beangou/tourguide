package com.tourguide.common.enums;

import com.tourguide.utils.StringUtils;

/**
 * 各种内容类型
 * Created by liutongbin on 2017/7/15.
 */
public enum ContentTypeEnum {

    LINK("Link"),
    ARTICLE("Article"),
    OTHERS("others")
    ;

    private String name;

    ContentTypeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static ContentTypeEnum getEnumByName(String name) {
        if (StringUtils.isBlank(name)) {
            return OTHERS;
        }
        for(ContentTypeEnum contentTypeEnum : values()) {
            if (contentTypeEnum.getName().equals(name)) {
                return contentTypeEnum;
            }
        }
        return OTHERS;
    }
}
