package com.alibou.example;

public record StudentsDto(
        String firstName,
        String lastName,
        String email,
        Integer schoolId
) {
}
