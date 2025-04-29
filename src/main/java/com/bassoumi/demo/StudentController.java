package com.bassoumi.demo;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
   private  final studentRepository repository;

   public StudentController(studentRepository repository) {
       this.repository = repository;
   }


    @PostMapping("/students")
    public student post(
            @RequestBody StudentDto dto
    ){
       var student = toStudent(dto);
       return repository.save(student);
    }
    private student toStudent(StudentDto dto) {
        student student = new student();
        student.setFirstname(dto.firstname());
        student.setLastname(dto.lastname());
        student.setEmail(dto.email());


        if (dto.schoolId() != null) {
            School school = new School();
            school.setId(dto.schoolId());
            student.setSchool(school);
        } else {
            student.setSchool(null); // explicitly set null or omit this line if default is null
        }

        return student;
    }


    @GetMapping("/students")
    public List<student> findAllStudent(){
       return  repository.findAll();
    }
    @GetMapping("/students/{student-id}")
    public  student findStudentById(
            @PathVariable("student-id") Integer id) {
        return repository.findById(id).orElse(new student());
    }


    @GetMapping("/students/search/{student-name}")
    public List<student>  findStudentByName(
            @PathVariable("student-name") String name) {
        return repository.findAllByFirstnameContaining(name);
    }
    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(
            @PathVariable("student-id") Integer id
    ) {
       repository.deleteById(id);
    }




}
