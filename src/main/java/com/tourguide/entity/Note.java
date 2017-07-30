package com.tourguide.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;

/**
 * 笔记
 * Created by liutongbin on 2017/7/30.
 */
@Getter
@Setter
public class Note extends BaseDbEntity {

    @Id
    private String id;

    /**
     * 笔记类型， 0：casual， 1：excerpt
     */
    private byte type;

    private String userId;

    /**
     * 标题
     */
    private String headline;

    /**
     * 内容
     */
    private String content;

}
