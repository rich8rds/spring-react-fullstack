package com.richards.spring.service.serviceimpl;

import com.richards.spring.dto.StudentDto;
import com.richards.spring.entity.Student;
import com.richards.spring.enums.Gender;
import com.richards.spring.exceptions.AlreadyExistsException;
import com.richards.spring.repository.StudentRepository;
import com.richards.spring.apiresponse.ApiResponse;
import com.richards.spring.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public ApiResponse<Student> addNewStudent(StudentDto studentDto) {
        String name = studentDto.getName();
        String email = studentDto.getEmail();
        Gender gender = studentDto.getGender();

        if(studentRepository.existsByEmail(email))
            throw new AlreadyExistsException("Email Already Exists");

        Student student = Student.builder()
                .name(name).email(email).gender(gender)
                .build();

        return new ApiResponse<>("STUDENT SAVED",
                "Student saved successfully",
                HttpStatus.OK,
                studentRepository.save(student));
    }

    @Override
    public String deleteStudent(Long id) {
        boolean studentExists = studentRepository.existsById(id);
        if(!studentExists) throw new IllegalArgumentException("Student with id: " + id + " does not exist");
        studentRepository.deleteById(id);
        return " has been deleted from the system.";
    }
}
