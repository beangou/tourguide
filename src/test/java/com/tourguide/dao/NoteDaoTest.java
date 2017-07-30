package com.tourguide.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import service.BaseTest;

import static org.junit.Assert.*;

/**
 * Created by liutongbin on 2017/7/30.
 */
public class NoteDaoTest extends BaseTest {

    @Autowired
    private NoteDao noteDao;

    @Test
    public void count() throws Exception {
        System.out.println("==" + noteDao.count("da5e1d7a221444a99b7028a9a00d2a3f"));
    }

}