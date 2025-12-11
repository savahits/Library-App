package ru.shmelev.libraryapp.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.shmelev.libraryapp.dto.request.SaveAuthorRequest;
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
    @ResponseStatus(HttpStatus.OK)
    public List<AuthorResponse> getAuthors() {
        return authorService.findAll();
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorResponse save(@RequestBody @Valid SaveAuthorRequest request) {
        return authorService.save(request);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(@RequestParam Long id) {
        authorService.delete(id);
    }

}
