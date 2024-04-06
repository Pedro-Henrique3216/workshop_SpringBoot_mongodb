package com.pedrohenrique.workshopmongo.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

public record CommentDTO(String text, Date date, AuthorDTO author) {
}
