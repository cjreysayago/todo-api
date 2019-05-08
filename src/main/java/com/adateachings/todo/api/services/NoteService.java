package com.adateachings.todo.api.services;

import com.adateachings.todo.api.repositories.NoteRepository;
import com.adateachings.todo.api.models.Note;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    /**
     * Returns all notes using JPA
     * @return Iterable<Note>
     */
    public ArrayList<Map<String, Object>> index() {
        ArrayList<Map<String, Object>> notes = new ArrayList<>();

        //Adding resources to ArrayList
        this.noteRepository.findAll().forEach(note -> notes.add(note.getNote()));

        return notes;
    }

    public Note store(Note note) {
        return this.noteRepository.save(note);
    }

}
