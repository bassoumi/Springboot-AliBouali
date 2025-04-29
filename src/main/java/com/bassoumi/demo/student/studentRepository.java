package com.bassoumi.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface studentRepository  extends JpaRepository <student, Integer> {

    List<student> findAllByFirstnameContaining(String firstname);




}
