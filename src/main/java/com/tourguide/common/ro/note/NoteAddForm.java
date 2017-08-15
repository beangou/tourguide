package com.tourguide.common.ro.note;

import com.tourguide.common.ro.BaseUserParamsRo;
import com.tourguide.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.websocket.server.ServerEndpoint;

/**
 * Created by liutongbin on 2017/7/30.
 */
@Getter
@Setter
public class NoteAddForm extends BaseUserParamsRo {

    /**
     * 笔记类型， 0：casual， 1：excerpt
     */
    private byte type;

    /**
     * 标题
     */
    private String headline;

    /**
     * 内容
     */
    private String content;


}
