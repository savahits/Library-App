package ru.shmelev.libraryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.shmelev.libraryapp.entity.Reader;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Long> {

}
