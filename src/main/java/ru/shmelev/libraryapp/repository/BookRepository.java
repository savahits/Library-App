package ru.shmelev.libraryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shmelev.libraryapp.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
