package com.tourguide.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
public class User extends BaseDbEntity {

    // @Id注解必须要有，否则更新会失败
    @Id
    private String id;

    private String mobile; // 手机号

    private String password; // 密码

    private String avatar; // 头像

    private String nickname; // 昵称

    private String qr; // 二维码

    private String address; // 住址

    private String email; // 邮箱

    private String salt; // 密码加密盐
}