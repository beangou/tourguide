package com.tourguide.dao;

import com.tourguide.common.TourguideException;
import com.tourguide.entity.Note;
import com.tourguide.entity.Scenery;
import com.tourguide.mapper.NoteMapper;
import com.tourguide.utils.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * Created by liutongbin on 2017/7/30.
 */
@Repository
public class NoteDao {

    @Autowired
    private NoteMapper noteMapper;

    public int insert(Note note) {
        note.setId(StringUtils.getUUID());
        Date now = new Date();
        note.setCreated(now);
        note.setUpdated(now);
        return noteMapper.insert(note);
    }

    public int update(Note note) {
        note.setUpdated(new Date());
        return noteMapper.updateByPrimaryKeySelective(note);
    }

    public int delete(String id) {
        Note note = noteMapper.selectByPrimaryKey(id);
        if (note == null) {
            throw new TourguideException("该笔记不存在");
        }
        note.setDeleted(new Date());
        return noteMapper.updateByPrimaryKey(note);
    }

    public List<Note> findByPage(String userId, int page, int size) {
        Example example = new Example(Note.class);
        example.createCriteria().andIsNull("deleted").andEqualTo("userId", userId);
        example.setOrderByClause("created");
        // 从第一页开始
        RowBounds rowBounds = new RowBounds((page-1)*size, size);
        return noteMapper.selectByExampleAndRowBounds(example, rowBounds);
    }

    public int count(String userId) {
        Example example = new Example(Note.class);
        example.createCriteria().andIsNull("deleted").andEqualTo("userId", userId);
        return noteMapper.selectCountByExample(example);
    }

    public Note findById(String id) {
        if (StringUtils.isBlank(id)) {
            throw new TourguideException("id不能为空");
        }
        return noteMapper.selectByPrimaryKey(id);
    }

}
