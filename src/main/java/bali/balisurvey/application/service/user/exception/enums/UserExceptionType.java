package bali.balisurvey.application.service.user.exception.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum UserExceptionType {
    EXIST_USER(HttpStatus.BAD_REQUEST,"UE001", "이미 존재하는 사용자입니다."),
    NOT_FOUND(HttpStatus.BAD_REQUEST, "UE002", "사용자를 찾을 수 없습니다."),
    ;
    private final HttpStatus status;
    private final String code;
    private final String message;
}
