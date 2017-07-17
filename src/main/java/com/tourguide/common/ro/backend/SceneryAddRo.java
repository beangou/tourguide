package com.tourguide.common.ro.backend;

import com.tourguide.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by liutongbin on 2017/7/17.
 */
@Getter
@Setter
public class SceneryAddRo extends BaseEntity {

    /**
     * 景点名称
     */
    private String name;

    /**
     * 链接类型（Link, Article）
     */
    private String type;

    /**
     * 如果类型是link，则该字段有值
     */
    private String link;

    /**
     * 景点图标
     */
    private String icon;

    /**
     * 是否是国内：true：国内， false：国外
     */
    private boolean isInternal;

    /**
     * 地址编码
     */
    private String addressCode;

    /**
     * 地址
     */
    private String addressValue;

    /**
     * 景点介绍（富文本）
     */
    private String description;

}
