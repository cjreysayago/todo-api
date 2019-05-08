package com.adateachings.todo.api.controllers;

import com.adateachings.todo.api.models.Note;
import com.adateachings.todo.api.services.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Map> index() {
        ArrayList<Map<String, Object>> notes = this.noteService.index();

        Map<String, Object> response = new HashMap();
        response.put("notes", notes);
        response.put("status", HttpStatus.OK.value());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Map> store(@RequestBody Note note) {
        Map<String, Object> response = new HashMap();
        response.put("notes", this.noteService.store(note).getNote());
        response.put("status", HttpStatus.CREATED.value());

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Map> find(@PathVariable("id") long id) {
        Optional<Note> note = this.noteService.find(id);

        Map<String, Object> response = new HashMap();
        response.put("data", note);
        response.put("status", note.isEmpty() ? HttpStatus.NOT_FOUND.value(): HttpStatus.OK.value());

        return new ResponseEntity<>(response, note.isEmpty() ? HttpStatus.NOT_FOUND: HttpStatus.OK);
    }
}
