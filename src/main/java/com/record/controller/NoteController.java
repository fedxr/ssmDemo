package com.record.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mchange.v2.lang.StringUtils;
import com.record.model.Note;
import com.record.service.Message;
import com.record.service.NoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/note")
public class NoteController {
    public static Logger logger = LoggerFactory.getLogger(NoteController.class);
    @Resource
    private NoteService noteService;

    /**
     * 查询note
     * @param userId1
     * @return
     */

    @RequestMapping("/showNote.do")
    public void selectNote(HttpServletRequest request, HttpServletResponse response,
                           @RequestParam(required = true, value = "userId") String userId1) throws IOException {
        List<Note> note;
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        long userId = Long.valueOf(userId1);
        if (userId == 0) {
            note = this.noteService.selectAllNotes();
        } else {
            note = this.noteService.selectNotesByUserId(userId);
        }
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(note));
        response.getWriter().close();
    }

    /**
     * 添加一个note
     * @param note
     * @return
     */
    @RequestMapping(value = "/submitNote.action", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Object submitNote(@RequestBody Note note, HttpServletRequest request) {
        try {
            logger.info("add note:[" + note.getJob() + "]");
            noteService.addNote(note);
        } catch (Exception e) {
            e.printStackTrace();
            return new Message("failed", false);
        }
        return new Message("success", true);
    }

    /**
     * 根据userId删除Note
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/deleteNote.json", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Object deleteTask(@RequestBody Note note) {
        try {
//            if (StringUtils.isBlank(note.getUserId())) {
//                return new Message("task id should not be null!", false);
//            }
            logger.info("delete note:[userId=" + note.getId() + "]");
            noteService.deleteNoteById(note.getId());
        } catch (Exception e) {
            e.printStackTrace();
            return new Message("delete task error!", false);
        }
        return new Message("delete task success!", true);
    }
}