package com.bassoumi.demo.student;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class StudentController {

  private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public StudentResponceDto saveStudent(
           @Valid @RequestBody StudentDto dto
    ){
            return   this.studentService.saveStudent(dto);
    }



    @GetMapping("/students")
    public List<StudentResponceDto> findAllStudent(){
       return  this.studentService.findAllStudent();
    }



    @GetMapping("/students/{student-id}")
    public  StudentResponceDto findStudentById(
            @PathVariable("student-id") Integer id) {
        return this.studentService.findStudentById(id);
    }


    @GetMapping("/students/search/{student-name}")
    public List<StudentResponceDto>  findStudentByName(
            @PathVariable("student-name") String name) {
        return this.studentService.findStudentByName(name);
    }
    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(
            @PathVariable("student-id") Integer id
    ) {
     this.studentService.delete(id);
    }

    @ExceptionHandler
    public ResponseEntity<?> handleMethodArgumentNotValidException(
    MethodArgumentNotValidException exp
    ) {
        var erreurs = new HashMap< String ,String>();
        exp.getBindingResult().getAllErrors().forEach(erreur -> {
            var filedName = ((FieldError)erreur).getField();
            var errorMessage = erreur.getDefaultMessage();
            erreurs.put(filedName, errorMessage);
        });
        return new ResponseEntity<>(erreurs, HttpStatus.BAD_REQUEST);

    }



}
