package bali.balisurvey.adapter.in.web.survey.dto.response;

import bali.balisurvey.application.port.in.survey.dto.result.CreateSurveyResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateSurveyResponse {

    private Long seq;
    private String title;
    private String description;

    public CreateSurveyResponse(CreateSurveyResult result) {
        this.seq = result.getSeq();
        this.title = result.getTitle();
        this.description = result.getDescription();
    }
}
