package ru.shmelev.libraryapp.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record SaveAuthorRequest(
    @NotBlank
    @JsonProperty("name")
    String name,

    @NotBlank
    @JsonProperty("surname")
    String surname,

    @NotNull
    @JsonProperty("dateBirth")
    LocalDate dateBirth
)
{ }
