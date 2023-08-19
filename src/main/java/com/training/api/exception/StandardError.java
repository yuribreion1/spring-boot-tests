package com.training.api.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class StandardError {

    LocalDateTime timestamp;
    Integer status;
    String error;
    String path;
}
