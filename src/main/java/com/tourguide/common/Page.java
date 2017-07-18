package com.tourguide.common;

import com.tourguide.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liutongbin on 2017/7/18.
 */
@Getter
@Setter
public class Page<T> extends BaseEntity {

    private int page = 0;

    private int size = 10;

    private int totalCount;

    private List<T> records = new ArrayList<>();

}
