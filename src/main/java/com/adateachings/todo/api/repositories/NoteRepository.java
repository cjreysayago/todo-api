package com.adateachings.todo.api.repositories;

import com.adateachings.todo.api.models.Note;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Note, Long> {}
