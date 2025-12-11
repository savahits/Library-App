package ru.shmelev.libraryapp.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.shmelev.libraryapp.dto.request.SaveAuthorRequest;
import ru.shmelev.libraryapp.dto.responce.AuthorResponse;
import ru.shmelev.libraryapp.entity.Author;
import ru.shmelev.libraryapp.repository.AuthorRepository;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Transactional()
    public List<AuthorResponse> findAll() {
        return authorRepository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    private AuthorResponse toResponse(Author author) {
        return new AuthorResponse(
                author.getId(),
                author.getName(),
                author.getSurname(),
                author.getBirthDate()
        );
    }

    @Transactional
    public AuthorResponse save(SaveAuthorRequest request) {
        Author author = new Author();
        author.setName(request.name());
        author.setSurname(request.surname());
        author.setBirthDate(request.dateBirth());

        authorRepository.save(author);

        return toResponse(author);

    }

    @Transactional()
    public AuthorResponse findById(Long id) {
        return authorRepository.findById(id)
                .map(this::toResponse)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Автор не найден"
                ));
    }

    @Transactional
    public void delete(Long id) {
        if (authorRepository.existsById(id))
        {
            authorRepository.deleteById(id);
        }
        else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND
            );
        }
    }

}
