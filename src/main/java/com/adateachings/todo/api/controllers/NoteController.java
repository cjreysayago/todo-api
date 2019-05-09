package com.adateachings.todo.api.controllers;

import com.adateachings.todo.api.models.Note;
import com.adateachings.todo.api.services.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RequestMapping("notes")
@RestController
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("")
    public Map index() {
        ArrayList<Note> notes = this.noteService.index();

        Map<String, Object> response = new HashMap();
        response.put("notes", notes);
        response.put("status", HttpStatus.OK.value());

        return response;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Map store(@RequestBody Note note) {
        Map<String, Object> response = new HashMap();
        response.put("note", this.noteService.store(note));
        response.put("status", HttpStatus.CREATED.value());

        return response;
    }

    @GetMapping("{id}")
    public Map find(@PathVariable("id") long id) {
        Optional<Note> note = this.noteService.find(id);

        Map<String, Object> response = new HashMap();
        response.put("note", note);
        response.put("status", HttpStatus.OK.value());

        return response;
    }

    @PutMapping("{id}/edit")
    public Map edit(@PathVariable("id") long id, @RequestBody Note newNote) {
        Optional<Note> note = this.noteService.find(id);

        this.noteService.edit(note.get(), newNote);

        Map<String, Object> response = new HashMap();
        response.put("note", note);
        response.put("status", HttpStatus.OK.value());

        return response;
    }

    @DeleteMapping("{id}")
    public Map delete(@PathVariable("id") long id) {
        Optional<Note> note = this.noteService.find(id);
        this.noteService.delete(note);

        Map<String, Object> response = new HashMap();
        response.put("status", HttpStatus.OK.value());

        return response;
    }
}
