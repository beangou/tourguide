package com.tourguide.common.vo;

import com.tourguide.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by liutongbin on 2017/7/8.
 */
@Getter
@Setter
public class UserDetailVo extends BaseEntity {

    private String id;

    private String mobile; // 手机号

    private Date created; // 创建时间

    private Date updated; // 更新时间

    private Date deleted; // 删除时间

    private String avatar; // 头像

    private String nickname; // 昵称

    private String qr; // 二维码

    private String address; // 住址

    private String email; // 邮箱

}
