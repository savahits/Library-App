package ru.shmelev.libraryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.shmelev.libraryapp.entity.Author;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    // query for text search
    @Query("SELECT a FROM Author a WHERE " +
            "LOWER(CONCAT(a.name, ' ', a.surname)) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
            "LOWER(CONCAT(a.surname, ' ', a.name)) LIKE LOWER(CONCAT('%', :search, '%'))")
    List<Author> searchByFullName(@Param("search") String search);
}
