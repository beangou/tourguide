package com.tourguide.service;

import com.tourguide.common.ro.backend.DictionaryListRo;
import com.tourguide.common.ro.backend.SceneryListRo;
import com.tourguide.dao.DictionaryDao;
import com.tourguide.entity.Dictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liutongbin on 2017/7/16.
 */
@Service
public class DictionaryService {

    @Autowired
    private DictionaryDao dictionaryDao;

    public List<Dictionary> findByType(DictionaryListRo listRo) {
        return dictionaryDao.findByPage(listRo.getType(), listRo.getPage(), listRo.getSize());
    }

}
