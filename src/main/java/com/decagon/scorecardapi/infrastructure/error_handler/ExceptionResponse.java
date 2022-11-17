package com.decagon.scorecardapi.infrastructure.error_handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class ExceptionResponse {
    private  String message;
    private  String details;
    private LocalDate timeStamp;
}
