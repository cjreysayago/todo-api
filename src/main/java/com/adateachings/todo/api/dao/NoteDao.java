package com.adateachings.todo.api.dao;

import com.adateachings.todo.api.models.Note;

import java.util.ArrayList;
import java.util.UUID;

public interface NoteDao {

    //Lists all Note resources
    ArrayList<Note> index();

    //Returns the given Note resource
    Note find(UUID id);

    //Returns the given Note resource and if not exists throws an Exception with 404
    Note findOrFail(UUID id);

    //Stores a new resource
    Note store(Note note);

    //Edits a resource
    Note edit(UUID id);

    //Delete a resource
    boolean delete(UUID id);
}
