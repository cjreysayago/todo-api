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
        ArrayList<Map<String, Object>> notes = this.noteService.index();

        Map<String, Object> response = new HashMap();
        response.put("notes", notes);
        response.put("status", HttpStatus.OK.value());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("")
    public Map<String, Object> store(@RequestBody Note note) {
        return this.noteService.store(note).getNote();
    }
}
