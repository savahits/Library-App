package ru.shmelev.libraryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.shmelev.libraryapp.entity.Reader;

import java.util.Optional;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Long> {
    boolean existsByEmail(String email);

    Optional<Reader> findByEmail(String email);
}
