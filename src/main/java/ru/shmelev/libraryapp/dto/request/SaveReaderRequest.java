package ru.shmelev.libraryapp.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SaveReaderRequest(
        @NotBlank(message = "Имя обязательно")
        @JsonProperty("name")
        String name,

        @JsonProperty("surname")
        @NotBlank(message = "Фамилия обязательно")
        String surname,

        @Email(message = "Некорректный email")
        @JsonProperty("email")
        @NotNull(message = "Email обязателен")
        String email
) {}
