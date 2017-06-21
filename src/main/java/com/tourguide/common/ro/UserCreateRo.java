package com.tourguide.common.ro;

import com.tourguide.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by liutongbin on 2017/4/5.
 */

@Getter
@Setter
public class UserCreateRo extends BaseEntity {

    private String mobile;

    /**
     * 前端传过来加密
     */
    private String password;

}
