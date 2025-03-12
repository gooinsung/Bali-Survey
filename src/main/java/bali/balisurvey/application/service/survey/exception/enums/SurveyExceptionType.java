package bali.balisurvey.application.service.survey.exception.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SurveyExceptionType {
    EXIST_SURVEY(HttpStatus.BAD_REQUEST,"SE001", "이미 존재하는 설문입니다."),
    DELETED_SURVEY(HttpStatus.BAD_REQUEST, "SE002", "삭제된 설문입니다."),
    ;
    private final HttpStatus status;
    private final String code;
    private final String message;
}
