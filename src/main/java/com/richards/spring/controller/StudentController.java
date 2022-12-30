package com.richards.spring.controller;

import com.richards.spring.dto.StudentDto;
import com.richards.spring.entity.Student;
import com.richards.spring.apiresponse.ApiResponse;
import com.richards.spring.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/students")
public class StudentController {
    private final StudentService studentService;
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping("/new")
    public ApiResponse<Student> addNewStudent(@Valid @RequestBody StudentDto studentDto) {
        return studentService.addNewStudent(studentDto);
    }

    @DeleteMapping("/{id}/delete")
    public ApiResponse<String> deleteStudent(@PathVariable Long id) {
        System.out.println("ID: " + id);
        String message = studentService.deleteStudent(id);
        return new ApiResponse<>("STUDENT DELETED",
                "Student: " + message,
                HttpStatus.OK, "DELETED");
    }
}
