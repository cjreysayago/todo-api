package com.adateachings.todo.api.dao;

import com.adateachings.todo.api.models.Note;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.UUID;

@Repository
public class NoteRepository implements NoteDao {
    private static final ArrayList<Note> notes = new ArrayList<>();

    @Override
    public ArrayList<Note> index() {

        return notes;
    }

    @Override
    public Note find(UUID id) {
        return null;
    }

    @Override
    public Note findOrFail(UUID id) {
        return null;
    }

    @Override
    public Note store(Note note) {
        note.setId(UUID.randomUUID());

        notes.add(note);
        return note;
    }

    @Override
    public Note edit(UUID id) {
        return null;
    }

    @Override
    public boolean delete(UUID id) {
        return false;
    }
}
