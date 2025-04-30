package com.bassoumi.demo.student;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {
    private StudentMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new StudentMapper();
    }


    @Test
    public void shoulMapStudentToStudent() {
        StudentDto dto = new StudentDto("jhon",
                "doe",
                "jhon@gmail.com",
                1);
        student student = mapper.toStudent(dto);
        assertEquals(dto.firstname(), student.getFirstname());
        assertEquals(dto.lastname(), student.getLastname());
        assertEquals(dto.email(), student.getEmail());
        assertNotNull(student.getSchool());
        assertEquals(dto.schoolId(), student.getSchool().getId());
    }


    @Test
    public void shoulMapStudentToStudentResponseDto() {
        student student = new student(
                "hey",
                "doe",
                "jhon@gmail.com",
                10);
        StudentResponceDto response = mapper.toStudentResponceDto(student);
        assertEquals(response.firstname(), student.getFirstname());
        assertEquals(response.lastname(), student.getLastname());
        assertEquals(response.email(), student.getEmail());
    }

}