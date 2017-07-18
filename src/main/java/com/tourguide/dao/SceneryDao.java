package com.tourguide.dao;

import com.tourguide.entity.Scenery;
import com.tourguide.mapper.SceneryMapper;
import com.tourguide.utils.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * Created by liutongbin on 2017/7/9.
 */
@Component
public class SceneryDao {

    @Autowired
    private SceneryMapper sceneryMapper;

    public int insert(Scenery scenery) {
        if (scenery == null) {
            return 0;
        }
        Date now = new Date();
        scenery.setCreated(now);
        scenery.setUpdated(now);
        return sceneryMapper.insert(scenery);
    }

    public int update(Scenery scenery) {
        if (scenery == null) {
            return 0;
        }
        scenery.setUpdated(new Date());
        return sceneryMapper.updateByPrimaryKeySelective(scenery);
    }

    public int count(String userId) {
        Example example = new Example(Scenery.class);
        example.createCriteria().andIsNull("deleted");
        if (StringUtils.isNoneBlank(userId)) {
            example.createCriteria().andEqualTo("userId", userId);
        }
        return sceneryMapper.selectCountByExample(example);
    }

    public List<Scenery> findByPage(String addressCode, int page, int size) {
        Example example = new Example(Scenery.class);
        example.createCriteria().andIsNull("deleted");
        if (StringUtils.isNotBlank(addressCode)) {
            example.createCriteria().andEqualTo("addressCode", addressCode);
        }
        example.setOrderByClause("created");
        // 从第一页开始
        RowBounds rowBounds = new RowBounds((page-1)*size, size);
        return sceneryMapper.selectByExampleAndRowBounds(example, rowBounds);
    }

    public List<Scenery> findByIds(List<String> idList) {
        Example example = new Example(Scenery.class);
        example.createCriteria().andIn("id", idList).andIsNull("deleted");;
        return sceneryMapper.selectByExample(example);
    }

    public Scenery findById(String id) {
        return sceneryMapper.selectByPrimaryKey(id);
    }
}
