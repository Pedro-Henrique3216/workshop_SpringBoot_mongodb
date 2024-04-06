package com.pedrohenrique.workshopmongo.dto;

import com.pedrohenrique.workshopmongo.domain.User;

public record AuthorDTO(String id, String name) {
    public AuthorDTO(User author) {
        this(author.getId(), author.getName());
    }
}
