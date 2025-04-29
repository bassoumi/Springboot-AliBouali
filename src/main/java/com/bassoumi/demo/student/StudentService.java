package com.bassoumi.demo.student;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final studentRepository repository;
    private final StudentMapper studentMapper;

    public StudentService(studentRepository repository, StudentMapper studentMapper) {
        this.repository = repository;
        this.studentMapper = studentMapper;
    }

    public StudentResponceDto saveStudent(StudentDto dto) {
        var student = studentMapper.toStudent(dto);
        var savedStudent = repository.save(student);
        return studentMapper.toStudentResponceDto(savedStudent);
    }

    public List<StudentResponceDto> findAllStudent() {
        return repository.findAll()
                .stream()
                .map(StudentMapper::toStudentResponceDto)
                .collect(Collectors.toList());
    }

    public  StudentResponceDto findStudentById(Integer id) {
        return repository.findById(id).map(StudentMapper::toStudentResponceDto).orElse(null);
    }

    public List<StudentResponceDto>  findStudentByName(String name) {
        return repository.findAllByFirstnameContaining(name).stream().map(StudentMapper::toStudentResponceDto).collect(Collectors.toList());
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

}
