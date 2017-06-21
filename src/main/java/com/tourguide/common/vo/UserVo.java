package com.tourguide.common.vo;

import com.tourguide.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by liutongbin on 2017/4/5.
 */
@Getter
@Setter
public class UserVo extends BaseEntity {

    private String id;

    private String mobile;

    private String avatar;

    private String nickname;

}
