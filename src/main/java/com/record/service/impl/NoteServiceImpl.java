package com.record.service.impl;

import com.record.dao.NoteDao;
import com.record.model.Note;
import com.record.service.NoteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("noteService")
public class NoteServiceImpl implements NoteService {

    @Resource
    private NoteDao noteDao;

    public void addNote(Note note) {
        noteDao.addNote(note);
    }

    public void deleteNoteById(long userId) {
        noteDao.deleteNoteById(userId);
    }

    public List<Note> selectAllNotes() {return this.noteDao.selectAllNotes();}

    public List<Note> selectNotesByUserId(long userId) {return this.noteDao.selectNotesByUserId(userId);}
}