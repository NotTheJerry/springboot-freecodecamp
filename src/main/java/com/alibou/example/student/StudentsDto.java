package com.alibou.example.student;

public record StudentsDto(
        String firstName,
        String lastName,
        String email,
        Integer schoolId
) {
}
