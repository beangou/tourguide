package com.tourguide.common.ro;

import com.tourguide.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by liutongbin on 2017/7/1.
 */
@Getter
@Setter
public class LoginRo extends BaseEntity {
    private String mobile;
    private String password;
}
