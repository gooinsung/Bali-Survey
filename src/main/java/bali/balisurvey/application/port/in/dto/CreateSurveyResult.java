package bali.balisurvey.application.port.in.dto;

import bali.balisurvey.domain.model.survey.Survey;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateSurveyResult {
    private Long seq;
    private String title;
    private String description;

    public CreateSurveyResult(Survey survey) {
        this.seq = survey.getSeq();
        this.title = survey.getTitle();
        this.description = survey.getDescription();
    }
}
