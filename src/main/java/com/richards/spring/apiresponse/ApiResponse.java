package com.richards.spring.apiresponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse <T> {
    private String message;
    private String debugMessage;
    private HttpStatus status;
    private T data;
}
