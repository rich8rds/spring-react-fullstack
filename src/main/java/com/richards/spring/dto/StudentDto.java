package com.richards.spring.dto;

import com.richards.spring.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDto {
    @NotBlank(message = "Field is required!")
    private String name;
    @Email(message = "Please input a valid email!")
    private String email;
    @NotNull(message = "Field is Required!")
    private Gender gender;
}
