package bali.balisurvey.application.service.survey.exception.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SurveyExceptionType {

    ;
    private final HttpStatus status;
    private final String message;
}
