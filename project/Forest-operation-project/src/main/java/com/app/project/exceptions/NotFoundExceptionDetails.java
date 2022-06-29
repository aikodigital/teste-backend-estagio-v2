package com.app.project.exceptions;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class NotFoundExceptionDetails {
    private String title;
    private int status;
    private String details;
    private LocalDateTime timestamp;
    private String developerMessage;
}
