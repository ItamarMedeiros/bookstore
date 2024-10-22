package com.example.bookstore.services;

import org.springframework.stereotype.Service;

import com.example.bookstore.dtos.AuthorRecordDto;
import com.example.bookstore.models.AuthorModel;
import com.example.bookstore.repositories.AuthorRepository;

import jakarta.transaction.Transactional;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Transactional
    public AuthorModel saveAuthor(AuthorRecordDto authorRecordDto) {
        AuthorModel author = new AuthorModel();
        author.setName(authorRecordDto.name());
        return authorRepository.save(author);

    }

    public boolean authorExists(String name) {
        return authorRepository.findAll().stream().anyMatch(author -> author.getName().equals(name));
    }

}
