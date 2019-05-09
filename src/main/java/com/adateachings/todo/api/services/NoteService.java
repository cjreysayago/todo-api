package com.adateachings.todo.api.services;

import com.adateachings.todo.api.repositories.NoteRepository;
import com.adateachings.todo.api.models.Note;
import exceptions.ResourceNotFound;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

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
    public ArrayList<Note> index() {
        ArrayList<Note> notes = new ArrayList<>();

        //Adding resources to ArrayList
        this.noteRepository.findAll().forEach(note -> notes.add(note));

        return notes;
    }

    public Note store(Note note) {
        return this.noteRepository.save(note);
    }

    public Optional<Note> find(long id) {
        Optional<Note> note = this.noteRepository.findById(id);
        if(note.isEmpty()) throw new ResourceNotFound();

        return note;
    }

    public Note edit(Note note, Note newNote) {
        note.setTitle(newNote.getTitle());
        note.setDescription(newNote.getDescription());

        this.noteRepository.save(note);

        return note;
    }

    public void delete(Optional<Note> note) {
        this.noteRepository.delete(note.get());
    }

}
