package com.tourguide.common.enums;

/**
 * Created by liutongbin on 2017/7/30.
 */
public enum NoteTypeEnum {

    CASUAL((byte)0, "casual"),
    EXCERPT((byte)1, "excerpt"),
    ;

    private byte code;

    private String desc;

    public byte getCode() {
        return code;
    }

    public void setCode(byte code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    NoteTypeEnum(byte code, String desc) {
        this.code = code;
        this.desc = desc;

    }
}
