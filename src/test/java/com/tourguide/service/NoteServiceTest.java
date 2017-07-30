package com.tourguide.service;

import com.alibaba.druid.support.json.JSONUtils;
import com.tourguide.common.enums.NoteTypeEnum;
import com.tourguide.common.ro.note.NoteAddForm;
import com.tourguide.common.ro.note.NoteUpdateForm;
import com.tourguide.utils.JsonUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import service.BaseTest;

import static org.junit.Assert.*;

/**
 * Created by liutongbin on 2017/7/30.
 */
public class NoteServiceTest extends BaseTest {

    @Autowired
    private NoteService noteService;

    @Test
    public void add() throws Exception {
        NoteAddForm noteAddForm = new NoteAddForm();
        noteAddForm.setContent("abcde");
        noteAddForm.setHeadline("hahaha");
        noteAddForm.setType(NoteTypeEnum.CASUAL.getCode());
        System.out.println("result= " + noteService.add(noteAddForm, "da5e1d7a221444a99b7028a9a00d2a3f"));
    }

    @Test
    public void delete() {
        noteService.delete("a24a0148fc2e42c08dd914abe0097c67");
    }

    @Test
    public void update() {
        NoteUpdateForm noteUpdateForm = new NoteUpdateForm();
        noteUpdateForm.setType(NoteTypeEnum.CASUAL.getCode());
        noteUpdateForm.setContent("sdjksjk");
        noteUpdateForm.setId("821d38d4b29b489bb465229ee9fb2a34");
        noteService.update(noteUpdateForm, "da5e1d7a221444a99b7028a9a00d2a3f");
    }

    @Test
    public void findByPage() {
        System.out.println("result=" + JsonUtil.toJsonString(noteService.findByPage("da5e1d7a221444a99b7028a9a00d2a3f", 0, 10)));
    }

    @Test
    public void detail() {
        System.out.println("ersult=" + JsonUtil.toJsonString(noteService.detail("821d38d4b29b489bb465229ee9fb2a34")));
    }

}