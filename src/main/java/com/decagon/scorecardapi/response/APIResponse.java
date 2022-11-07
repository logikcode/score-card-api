package com.decagon.scorecardapi.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class APIResponse<T> {
    private String message;
    private LocalDateTime timeStamp;
    private T data;

    public APIResponse(String message, LocalDateTime timeStamp, T data) {
        this.message = message;
        this.timeStamp = timeStamp;
        this.data = data;
    }

    public APIResponse(String message, LocalDateTime timeStamp) {
        this.message = message;
        this.timeStamp = timeStamp;
    }
}
