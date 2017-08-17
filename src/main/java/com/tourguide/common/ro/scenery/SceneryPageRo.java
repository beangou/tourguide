package com.tourguide.common.ro.scenery;

import com.tourguide.common.ro.PageParamsRo;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by liutongbin on 2017/7/18.
 */
@Getter
@Setter
public class SceneryPageRo extends PageParamsRo {

    private String addressCode;

    /**
     * 是否是国内景点（true：是，false：不是）
     */
    private boolean isInternal;

}
