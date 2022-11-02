package com.decagon.scorecardapi.dto.responsedto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class APIResponse<T> {
    private Boolean status;
    private String message;
    private T data;

}
