package com.tourguide.common.ro.backend;

import com.tourguide.common.ro.PageParamsRo;
import com.tourguide.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by liutongbin on 2017/7/16.
 */
@Getter
@Setter
public class DictionaryListRo extends PageParamsRo {

    /**
     * 字典类型
     */
    private int type;

}
