package com.alibou.example.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {

    //Which service we want to test
    @InjectMocks
    private StudentService studentService;

    //Declare the dependencies
    @Mock
    private StudentRepository repository;

    @Mock
    private StudentMapper studentMapper;



    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void should_successfully_save_a_student() {
        //Given
        StudentDto dto = new StudentDto("John","Doe","john@email.com",1);
        Student student = new Student("John","Doe","john@email.com",20);
        Student savedStudent = new Student("John","Doe","john@email.com",20);
        savedStudent.setId(1);

        //Mock the calls
        when(studentMapper.toStudent(dto)).thenReturn(student);
        when(repository.save(student)).thenReturn(savedStudent);
        when(studentMapper.toStudentResponseDto(savedStudent)).thenReturn(new StudentResponseDto("John","Doe","john@email.com"));

        //When
        StudentResponseDto response = studentService.saveStudent(dto);

        //Then
        assertEquals(dto.firstName(), response.firstName());
        assertEquals(dto.lastName(), response.lastName());
        assertEquals(dto.email(), response.email());

        verify(studentMapper, times(1)).toStudent(dto);
        verify(repository, times(1)).save(student);
        verify(studentMapper, times(1)).toStudentResponseDto(savedStudent);
    }

    @Test
    public void function_findAll () {
        //Given
        List<Student> students = new ArrayList<>();
        students.add(new Student("John","Doe","john@email.com",20));

        //Mock the calls
        when(repository.findAll()).thenReturn(students);
        when(studentMapper.toStudentResponseDto(any(Student.class)))
                .thenReturn( new StudentResponseDto("John","Doe","john@email.com") );

        //When
        List<StudentResponseDto> responseDtos = studentService.findAllStudent();

        //Then
        assertEquals(students.size(), responseDtos.size());
        verify(repository, times(1)).findAll();
    }


    @Test
    public void function_find_by_id () {
        //Given
        Integer studentId = 1;
        Student student = new Student("John","Doe","john@email.com",20);


        //Mock the calls
        when(repository.findById(studentId)).thenReturn(Optional.of(student));
        when(studentMapper.toStudentResponseDto(any(Student.class)))
                .thenReturn( new StudentResponseDto("John","Doe","john@email.com") );


        //When
        StudentResponseDto dto = studentService.findStudentById(studentId);

        //Then
        assertEquals(dto.firstName(), student.getFirstName());
        assertEquals(dto.lastName(), student.getLastName());
        assertEquals(dto.email(), student.getEmail());
        verify(repository, times(1)).findById( studentId );
    }

    @Test
    public void function_find_by_name () {
        //Given
        String studentName = "John";
        List<Student> students = new ArrayList<>();
        students.add(new Student("John","Doe","john@email.com",20));

        //Mock the calls
        when(repository.findAllByFirstNameContaining(studentName)).thenReturn(students);
        when(studentMapper.toStudentResponseDto(any(Student.class)))
                .thenReturn( new StudentResponseDto("John","Doe","john@email.com") );

        //When
        var responseDto = studentService.findStudentByName(studentName);

        //Then
        assertEquals(students.size(), responseDto.size());
        verify(repository, times(1)).findAllByFirstNameContaining(studentName);
    }
}