package com.alibou.example.student;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record StudentsDto(
        @NotEmpty(message = "Firstname should not be empty")
        String firstName,
        @NotEmpty(message = "Lastname should not be empty")
        String lastName,
        String email,
        Integer schoolId
) {
}
