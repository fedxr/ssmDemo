package com.record.dao;

import com.record.model.Note;
import com.record.model.User;

import java.util.List;

public interface NoteDao {
    void addNote(Note note);

    void deleteNoteById(long userId);

    List<Note> selectAllNotes();

    List<Note> selectNotesByUserId(long id);
}
