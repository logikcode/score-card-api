package com.decagon.scorecardapi.usecase.payload.request;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class PodDto {
private String podName;
private String stackAssociateName;
private String programAssociateName;

}
