package com.bassoumi.demo.student;

import org.junit.jupiter.api.BeforeAll;
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
import static org.mockito.ArgumentMatchers.any;

class StudentServiceTest {

    @InjectMocks
    private StudentService studentService;
    @Mock
    private studentRepository repository;
    @Mock
    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
@Test

public void should_successfully_create_a_student() {
    StudentDto dto = new StudentDto("jhon",
            "doe",
            "jhon@gmail.com",
            1
    );
    student student = new student(
            "jhon",
            "doe",
            "jhon@gmail.com",
            10
    );

    student savedStudent = new student(
            "jhon",
            "doe",
            "jhon@gmail.com",
            10
    );
savedStudent.setId(1);
    Mockito.when(studentMapper.toStudent(dto)).thenReturn(student);
    Mockito.when(repository.save(student)).thenReturn(savedStudent);
    Mockito.when(studentMapper.toStudentResponceDto(savedStudent)).thenReturn(new StudentResponceDto(
            "jhon","doe","jhon@gmail.com"
    ));

    StudentResponceDto responseDto = studentService.saveStudent(dto);

    assertEquals(dto.firstname(),responseDto.firstname());
    assertEquals(dto.lastname(),responseDto.lastname());
    assertEquals(dto.email(),responseDto.email());

Mockito.verify(studentMapper,Mockito.times(1)).toStudent(dto);
Mockito.verify(repository,Mockito.times(1)).save(student);
Mockito.verify(studentMapper,Mockito.times(1)).toStudentResponceDto(savedStudent);

}

@Test
    public void should_return_all_students(){
    List<student> students = new ArrayList<>();
    students.add(new student(
            "jhon",
            "doe",
            "jhon@gmail.com",
            10
    ));
    Mockito.when(repository.findAll()).thenReturn(students);
    Mockito.when(studentMapper.toStudentResponceDto(any(student.class))).thenReturn(
            new StudentResponceDto(
                    "jhon",
                    "doe",
                    "jhon@gmail.com"

            )
    );
    List<StudentResponceDto> responceDtos = studentService.findAllStudent();
    assertEquals(students.size(),responceDtos.size());
    Mockito.verify(repository,Mockito.times(1)).findAll();
}


    @Test
    public void should_return_student_by_id(){
        Integer studentId = 1;
        student student = new student(
                "jhon",
                "doe",
                "jhon@gmail.com",
                10
        );

        Mockito.when(repository.findById(studentId)).thenReturn(Optional.of(student));
        Mockito.when(studentMapper.toStudentResponceDto(any(student.class))).thenReturn(new StudentResponceDto(
                "jhon",
                "doe",
                "jhon@gmail.com"

        ));
        StudentResponceDto dto = studentService.findStudentById(studentId);
        assertEquals(dto.firstname(),student.getFirstname());
        assertEquals(dto.lastname(),student.getLastname());
        assertEquals(dto.email(),student.getEmail());

    }

    @Test
    public void should_return_student_by_name() {
        String name = "jhon";

        List<student> students = new ArrayList<>();
        students.add(new student(
                "jhon",
                "doe",
                "jhon@gmail.com",
                10
        ));
        Mockito.when(repository.findAllByFirstnameContaining(name)).thenReturn(students);
        Mockito.when(studentMapper.toStudentResponceDto(any(student.class))).thenReturn(
                new StudentResponceDto(
                        "jhon",
                        "doe",
                        "jhon@gmail.com"

                )
        );
        var responseDto = studentService.findStudentByName(name);
        assertEquals(students.size(), responseDto.size());
        Mockito.verify(repository, Mockito.times(1)).findAllByFirstnameContaining(name);

    }

    @Test
    public void should_delete_student_by_id() {
        // Given
        Integer studentId = 1;

        // When
        studentService.delete(studentId);

        // Then
        Mockito.verify(repository, Mockito.times(1)).deleteById(studentId);
    }


}