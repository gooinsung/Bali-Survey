package bali.balisurvey.application.service.user.exception;

import bali.balisurvey.application.service.user.exception.enums.UserExceptionType;
import lombok.Getter;

public class UserException extends RuntimeException {

    @Getter
    private UserExceptionType type;

    public UserException(UserExceptionType type) {
        super(type.getMessage());
        this.type = type;
    }

}
