package ru.shmelev.libraryapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.shmelev.libraryapp.dto.responce.AuthorResponse;
import ru.shmelev.libraryapp.service.AuthorService;

import java.util.List;

@RestController
@RequestMapping("api/authors")
public class AuthorController {

    AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<AuthorResponse> getAuthors() {
        return authorService.findAll();
    }

}
