package bali.balisurvey.application.port.in.survey.dto.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateSurveyResult {

    private Long seq;
    private String title;
    private String description;
}
