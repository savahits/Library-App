package ru.shmelev.libraryapp.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record SaveReaderRequest(
        @NotBlank(message = "Имя обязательно")
        @JsonProperty("name")
        String name,

        @JsonProperty("surname")
        String surname,

        @Email(message = "Некорректный email")
        @JsonProperty("email")
        String email
) {}