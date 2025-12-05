package ru.shmelev.libraryapp.entity;

import jakarta.persistence.*;

@Entity
public class Reader {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public Reader(Long id, String name, String surname, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
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

    private String name;
    private String surname;
    private String email;
}
