package com.adateachings.todo.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    protected Note() {};
    public Note(@JsonProperty("id") Long id,
                @JsonProperty("title") String title,
                @JsonProperty("description") String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Map<String, Object> getNote() {
        Map<String, Object> note = new HashMap();

        note.put("id", this.id);
        note.put("title", this.title);
        note.put("description", this.description);

        return note;
    }
}
