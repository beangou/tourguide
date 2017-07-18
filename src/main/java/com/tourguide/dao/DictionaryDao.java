package com.tourguide.dao;

import com.tourguide.entity.Dictionary;
import com.tourguide.mapper.DictionaryMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by liutongbin on 2017/7/16.
 */
@Component
public class DictionaryDao {

    @Autowired
    private DictionaryMapper dictionaryMapper;

    public List<Dictionary> findByPage(int type, int page, int size) {
        Example example = new Example(Dictionary.class);
        example.createCriteria().andEqualTo("type", type).andIsNull("deleted");;
        RowBounds rowBounds = new RowBounds((page-1)*size, size);
        return dictionaryMapper.selectByExampleAndRowBounds(example, rowBounds);
    }

}
