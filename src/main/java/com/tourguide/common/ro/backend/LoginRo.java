package com.tourguide.common.ro.backend;

import com.tourguide.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by liutongbin on 2017/7/16.
 */
@Getter
@Setter
public class LoginRo extends BaseEntity {

    private String email;

    private String password;

}
