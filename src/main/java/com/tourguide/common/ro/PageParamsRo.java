package com.tourguide.common.ro;

import com.tourguide.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by liutongbin on 2017/7/16.
 */
@Getter
@Setter
public class PageParamsRo extends BaseUserParamsRo {

    private int page;

    private int size;

}
