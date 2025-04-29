package com.bassoumi.demo.school;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {
    private final SchoolRepository SchoolRepository;
    private final SchoolMapper SchoolMapper;

    public SchoolService(SchoolRepository schoolRepository, SchoolMapper schoolMapper) {
        SchoolRepository = schoolRepository;
        SchoolMapper = schoolMapper;
    }

    public SchoolDto saveSchool(SchoolDto dto) {
        var school = SchoolMapper.toschool(dto);
        var savecSchool = SchoolRepository.save(school);
        return SchoolMapper.toschoolDto(savecSchool);
    }

    public List<SchoolDto> findAll(){
        return SchoolRepository.findAll()
                .stream()
                .map(SchoolMapper::toschoolDto)
                .collect(Collectors.toList());    }
}
