package bali.balisurvey.application.port.in.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateSurveyResult {
    private Long seq;
    private String title;
    private String description;
}
