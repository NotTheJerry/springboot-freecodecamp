package com.alibou.example;

public class SchoolMapper {
    public School toSchool (SchoolDto dto){
        return new School(dto.name());
    }

    public SchoolDto toSchoolDto (School school) {
        return new SchoolDto(school.getName());
    }
}