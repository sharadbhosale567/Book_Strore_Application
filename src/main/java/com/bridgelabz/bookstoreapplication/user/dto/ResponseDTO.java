package com.bridgelabz.bookstoreapplication.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ResponseDTO {
    private String message;
    private Object data;
}
