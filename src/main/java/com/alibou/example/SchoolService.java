package com.alibou.example;

import java.util.List;
import java.util.stream.Collectors;

public class SchoolService {
    private final SchoolRepository schoolRepository;

    private final SchoolMapper schoolMapper;

    public SchoolService(SchoolRepository schoolRepository, SchoolMapper schoolMapper) {
        this.schoolRepository = schoolRepository;
        this.schoolMapper = schoolMapper;
    }

    public SchoolDto create ( SchoolDto dto ) {
        var school = schoolMapper.toSchool(dto);
        var savedSchool = schoolRepository.save(school);
        return  dto;
    }

    public List<SchoolDto> findAll () {
        return schoolRepository
                .findAll()
                .stream()
                .map(schoolMapper::toSchoolDto)
                .collect(Collectors.toList());
    }
}
