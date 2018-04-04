package com.record.service;

import com.record.model.Note;
import com.record.model.User;

import java.util.List;

public interface NoteService {
    public void addNote(Note note);

    public void deleteNoteById(long userId);

    public List<Note> selectAllNotes();

    public List<Note> selectNotesByUserId(long userId);
}
