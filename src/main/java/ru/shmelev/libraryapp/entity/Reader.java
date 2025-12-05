package ru.shmelev.libraryapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "reader")
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Измените на IDENTITY
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false) // Добавьте nullable если нужно
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email", unique = true) // Добавьте unique если email должен быть уникальным
    private String email;

    // Конструкторы остаются
    public Reader(Long id, String name, String surname, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public Reader() {}

    @Override
    public String toString() {
        return "Reader{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}