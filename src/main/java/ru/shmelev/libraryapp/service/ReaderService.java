package ru.shmelev.libraryapp.service;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.shmelev.libraryapp.dto.request.SaveReaderRequest;
import ru.shmelev.libraryapp.dto.responce.ReaderResponse;
import ru.shmelev.libraryapp.entity.Reader;
import ru.shmelev.libraryapp.repository.ReaderRepository;

import java.util.List;

@Service
public class ReaderService {

    private final ReaderRepository readerRepository;

    @Autowired
    public ReaderService(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    @Transactional()
    public List<ReaderResponse> findAll() {
        return readerRepository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    @Transactional()
    public ReaderResponse findById(Long id) {
        return readerRepository.findById(id)
                .map(this::toResponse)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Читатель не найден"
                ));
    }

    private ReaderResponse toResponse(Reader reader) {
        return new ReaderResponse(
                reader.getId(),
                reader.getName(),
                reader.getSurname(),
                reader.getEmail()
        );
    }

    @Transactional
    public ReaderResponse save(@Valid @NotNull SaveReaderRequest request) {
        if (readerRepository.existsByEmail(request.email())){
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,  // Status 409
                    "Email уже используется"
            );
        }

        Reader reader = new Reader();
        reader.setName(request.name());
        reader.setEmail(request.email());
        reader.setSurname(request.surname());

        Reader saveReader = readerRepository.save(reader);

        return new ReaderResponse(
                saveReader.getId(),
                saveReader.getName(),
                saveReader.getSurname(),
                saveReader.getEmail()
        );
    }

    @Transactional
    public void delete(Long id) {
        if (!readerRepository.existsById(id)){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Reader not found"
            );
        }

        readerRepository.deleteById(id);
    }

    @Transactional
    public ReaderResponse update(Long id, @NotNull SaveReaderRequest request) {

        Reader reader = readerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Reader not found"
                ));

        if (!reader.getEmail().equals(request.email()) &&
                readerRepository.existsByEmail(request.email())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Email уже используется другим пользователем"
            );
        }

        ReaderResponse currentState = toResponse(reader);
        ReaderResponse newState = new ReaderResponse(
                reader.getId(),
                request.name(),
                request.surname(),
                request.email()
        );

        if (currentState.equals(newState)) {
            return currentState;
        }

        reader.setName(request.name());
        reader.setSurname(request.surname());
        reader.setEmail(request.email());

        Reader updatedReader = readerRepository.save(reader);

        return toResponse(updatedReader);
    }

}
