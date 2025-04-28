package com.bassoumi.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class schoolController {
    private final SchoolRepository SchoolRepository;

    public schoolController(SchoolRepository schoolRepository) {
        SchoolRepository = schoolRepository;
    }

    @PostMapping("/schools")
    public School create(
            @RequestBody School school
    ){
       return SchoolRepository.save(school);
    }

    @GetMapping("/schools")
    public List<School> findAll(){
        return SchoolRepository.findAll();
    }

}
