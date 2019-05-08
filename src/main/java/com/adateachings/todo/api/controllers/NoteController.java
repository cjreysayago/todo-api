package com.adateachings.todo.api.controllers;

import com.adateachings.todo.api.models.Note;
import com.adateachings.todo.api.services.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("notes")
@RestController
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("")
    public ResponseEntity<Map> index() {
        ArrayList<Note> notes = this.noteService.index();

        Map response = new HashMap();
        response.put("data", notes);
        response.put("status", notes.size() > 0 ? HttpStatus.OK.value() : HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(response, notes.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @PostMapping("")
    public Note store(@RequestBody Note note) {
        return this.noteService.store(note);
    }
}
