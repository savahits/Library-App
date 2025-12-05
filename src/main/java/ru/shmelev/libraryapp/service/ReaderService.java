package ru.shmelev.libraryapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    public List<Reader> findAll() {
        return readerRepository.findAll();
    }

    public Reader findById(Long id) {
        return readerRepository.findById(id).orElse(null);
    }

    public ReaderResponse save(SaveReaderRequest request) {
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


}
