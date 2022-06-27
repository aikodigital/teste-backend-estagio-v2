package com.aiko.testebackendestagiov2.exceptions;

import lombok.*;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ExceptionMessage {
    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
}
