package ru.shmelev.libraryapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import ru.shmelev.libraryapp.entity.Reader;
import ru.shmelev.libraryapp.service.ReaderService;

import java.util.List;

@RestController
@RequestMapping("api/readers")
public class ReaderController {

    ReaderService readerService;
    @Autowired
    public ReaderController(ReaderService readerService) {
        this.readerService = readerService;
    }

    @GetMapping
    public List<Reader> getReaders() {
        return readerService.findAll();
    }

    @GetMapping("/id")
    public Reader getReaderById(Long id) {
        return readerService.findById(id);
    }

}
