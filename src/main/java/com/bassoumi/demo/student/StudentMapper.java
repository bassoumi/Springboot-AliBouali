package com.bassoumi.demo.student;


import com.bassoumi.demo.school.School;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    public student toStudent(StudentDto dto) {
        student student = new student();
        student.setFirstname(dto.firstname());
        student.setLastname(dto.lastname());
        student.setEmail(dto.email());


        if (dto.schoolId() != null) {
            School school = new School();
            school.setId(dto.schoolId());
            student.setSchool(school);
        } else {
            student.setSchool(null);
        }

        return student;
    }

    public static StudentResponceDto toStudentResponceDto(student student) {
        return new StudentResponceDto(student.getFirstname(),
                student.getLastname(),
                student.getEmail());
    }

}
