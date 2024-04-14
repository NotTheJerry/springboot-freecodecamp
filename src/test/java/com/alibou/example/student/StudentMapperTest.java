package com.alibou.example.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {
    private StudentMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new StudentMapper();
    }

    @Test
    public void shootMapStudentToStudent () {
        StudentDto dto = new StudentDto("John", "Doe", "john@mail.com", 1);
        Student student = mapper.toStudent(dto);

        assertEquals(dto.firstName(), student.getFirstName());
        assertEquals(dto.lastName(), student.getLastName());
        assertEquals(dto.email(), student.getEmail());
        assertNotNull(student.getSchool());
        assertEquals(dto.schoolId(), student.getSchool().getId());

    }

    @Test
    public void should_throw_null_pointer_exception_when_studentDto_is_null() {
        var exp = assertThrows(NullPointerException.class, () -> mapper.toStudent(null));
        assertEquals("The student Dto should not be null", exp.getMessage());
    }

    @Test
    public void shootMapStudentToStudentResponseDto (){
        //Given
        Student student = new Student("Lou", "Min", "lou@gmail.com", 22);
        //When
        StudentResponseDto studentDto = mapper.toStudentResponseDto(student);
        //THen
        assertEquals(student.getFirstName(), studentDto.firstName());
        assertEquals(student.getFirstName(), studentDto.firstName());
        assertEquals(student.getFirstName(), studentDto.firstName());
    }

}