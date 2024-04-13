package com.alibou.example.student;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    public final StudentService studentService;

    public final StudentMapper studentMapper;

    public StudentController(StudentService studentService, StudentMapper studentMapper) {
        this.studentService = studentService;
        this.studentMapper = studentMapper;
    }

    @PostMapping("/students")
    public StudentResponseDto saveStudent(
            @RequestBody StudentsDto dto
    ) {
        return this.studentService.saveStudent(dto);
    }

    @GetMapping("/students")
    public List<StudentResponseDto> findAllStudent () {
        return studentService.findAllStudent();
    }

    @GetMapping("/students/{student-id}")
    public StudentResponseDto findStudentById (
            @PathVariable("student-id") Integer id
    ) {
        return studentService.findStudentById( id );
    }

    @GetMapping("/students/search/{student-name}")
    public List<StudentResponseDto> findStudentsByName (
            @PathVariable("student-name") String name
    ) {
        return studentService.findStudentByName(name);
    }

    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete (
            @PathVariable("student-id") Integer id
    ) {
        studentService.delete(id);
    }
}
