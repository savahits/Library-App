package ru.shmelev.libraryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.shmelev.libraryapp.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
