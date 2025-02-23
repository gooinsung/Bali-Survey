package bali.balisurvey.application.port.in.dto;

import lombok.Getter;

@Getter
public class CreateSurveyCommand {
    private String title;
    private String description;
}
