package bali.balisurvey.application.port.in.survey.dto.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateSurveyCommand {

    private String title;
    private String description;
}
