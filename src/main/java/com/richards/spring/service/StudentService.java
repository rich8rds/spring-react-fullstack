package com.richards.spring.service;

import com.richards.spring.dto.StudentDto;
import com.richards.spring.entity.Student;
import com.richards.spring.apiresponse.ApiResponse;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    ApiResponse<Student> addNewStudent(StudentDto studentDto);

    String deleteStudent(Long id);
}
