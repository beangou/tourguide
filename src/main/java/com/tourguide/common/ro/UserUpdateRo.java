package com.tourguide.common.ro;

import com.tourguide.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by liutongbin on 2017/4/5.
 */
@Getter
@Setter
public class UserUpdateRo extends BaseEntity {

    private String mobile;

    private String password;

    private String avatar;

    private String nickname;

    private String qr;

    private String address;

    private String email;

}
