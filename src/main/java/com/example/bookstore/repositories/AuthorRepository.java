package com.example.bookstore.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookstore.models.AuthorModel;

public interface AuthorRepository extends JpaRepository<AuthorModel, UUID> {

}
