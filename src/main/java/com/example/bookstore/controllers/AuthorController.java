package com.example.bookstore.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore.dtos.AuthorRecordDto;
import com.example.bookstore.models.AuthorModel;
import com.example.bookstore.services.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/bookstore/author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public ResponseEntity<AuthorModel> saveAuthor(@RequestBody AuthorRecordDto authorRecordDto) {

        var authorModel = authorService.saveAuthor(authorRecordDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(authorModel);
    }

}
