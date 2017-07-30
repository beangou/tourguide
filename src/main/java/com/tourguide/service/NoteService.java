package com.tourguide.service;

import com.tourguide.common.Page;
import com.tourguide.common.ro.note.NoteAddForm;
import com.tourguide.common.ro.note.NoteUpdateForm;
import com.tourguide.dao.NoteDao;
import com.tourguide.entity.Note;
import com.tourguide.entity.Scenery;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liutongbin on 2017/7/30.
 */
@Service
public class NoteService {

    @Autowired
    private NoteDao noteDao;

    public Boolean add(NoteAddForm noteAddForm, String userId) {
        Note note = new Note();
        BeanUtils.copyProperties(noteAddForm, note);
        note.setUserId(userId);
        return noteDao.insert(note) == 1;
    }

    public Boolean update(NoteUpdateForm noteUpdateForm, String userId) {
        Note note = new Note();
        BeanUtils.copyProperties(noteUpdateForm, note);
        note.setUserId(userId);
        return noteDao.update(note) == 1;
    }

    public Note detail(String id) {
        return noteDao.findById(id);
    }

    public Page<Note> findByPage(String userId, int page, int size) {
        List<Note> list = noteDao.findByPage(userId, page, size);
        int totalCount = noteDao.count(userId);
        Page<Note> notePage = new Page<>();
        notePage.setRecords(list);
        notePage.setPage(page);
        notePage.setTotalCount(totalCount);
        return notePage;
    }

    public Boolean delete(String id) {
        return noteDao.delete(id) == 1;
    }

}
