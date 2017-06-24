package com.tourguide.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
public class User extends BaseEntity {

    // @Id注解必须要有，否则更新会失败
    @Id
    private String id;

    private String mobile;

    private String password;

    private Date createAt;

    private Date updateaAt;

    private Date deleteAt;

    private String avatar;

    private String nickname;

    private String qr;

    private String address;

    private String email;

    private String salt;
}