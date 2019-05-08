package com.adateachings.todo.api.services;

import com.adateachings.todo.api.dao.NoteDao;
import com.adateachings.todo.api.models.Note;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class NoteService {

    private final NoteDao noteDao;

    public NoteService(NoteDao noteDao) {
        this.noteDao = noteDao;
    }

    public ArrayList<Note> index() {
        return this.noteDao.index();
    }

    public Note store(Note note) {
        return this.noteDao.store(note);
    }

}
