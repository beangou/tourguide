package com.tourguide.controller;

import com.tourguide.common.Page;
import com.tourguide.common.Result;
import com.tourguide.common.ro.note.NoteAddForm;
import com.tourguide.common.ro.note.NoteUpdateForm;
import com.tourguide.entity.Note;
import com.tourguide.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by liutongbin on 2017/7/30.
 */
@RestController
@RequestMapping("/note")
public class NoteController extends BaseController {

    @Autowired
    private NoteService noteService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<Boolean> add(@RequestBody NoteAddForm noteAddForm) {
        return Result.success(noteService.add(noteAddForm, getUserId(noteAddForm.getToken())));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result<Boolean> delete(String id) {
        return Result.success(noteService.delete(id));
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<Boolean> update(@RequestBody NoteUpdateForm noteUpdateForm) {
        return Result.success(noteService.update(noteUpdateForm, getUserId(noteUpdateForm.getToken())));
    }


    @RequestMapping(value = "/findByPage", method = RequestMethod.GET)
    public Result<Page<Note>> findByPage(int page, int size, String token) {
        return Result.success(noteService.findByPage(getUserId(token), page, size));
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public Result<Note> detail(String id) {
        return Result.success(noteService.detail(id));
    }
}
