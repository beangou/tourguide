package com.tourguide.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import java.util.Date;

/**
 * 用户-景点关联表
 * Created by liutongbin on 2017/7/9.
 */
@Getter
@Setter
public class UserScenery extends BaseDbEntity {

    @Id
    private String id;

    private String userId; // 用户id

    private String sceneryId; // 景点id


}
