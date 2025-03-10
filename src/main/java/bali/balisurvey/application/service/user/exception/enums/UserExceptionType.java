package bali.balisurvey.application.service.user.exception.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum UserExceptionType {
    EXIST_USER(HttpStatus.BAD_REQUEST, "이미 존재하는 사용자입니다."),
    ;
    private final HttpStatus status;
    private final String message;
}
