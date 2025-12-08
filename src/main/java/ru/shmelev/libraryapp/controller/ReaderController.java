package ru.shmelev.libraryapp.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.shmelev.libraryapp.dto.request.SaveReaderRequest;
import ru.shmelev.libraryapp.dto.responce.ReaderResponse;
import ru.shmelev.libraryapp.service.ReaderService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/readers")
@Validated
public class ReaderController {

    ReaderService readerService;
    @Autowired
    public ReaderController(ReaderService readerService) {
        this.readerService = readerService;
    }

    @GetMapping
    public List<ReaderResponse> getReaders() {
        return readerService.findAll();
    }

    @GetMapping("/id")
    public ReaderResponse getReaderById(Long id) {
        return readerService.findById(id);
    }

    @PostMapping("/new")
    public ReaderResponse createReader(
            @RequestBody @Valid SaveReaderRequest request) {

        return readerService.save(request);
    }

    @DeleteMapping
    public void deleteReaderById(Long id) {
        readerService.delete(id);
    }

    @PutMapping
    public ResponseEntity<ReaderResponse> updateReader(
            Long id, @Valid @RequestBody SaveReaderRequest request
    ){
        ReaderResponse response = readerService.update(id, request);

        return ResponseEntity
                .created(URI.create("/api/readers/" + response.id()))
                .body(response);
    }

}
