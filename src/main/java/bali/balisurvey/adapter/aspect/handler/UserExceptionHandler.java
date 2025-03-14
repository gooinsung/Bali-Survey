package bali.balisurvey.adapter.aspect.handler;

import bali.balisurvey.application.service.user.exception.UserException;
import bali.balisurvey.common.response.exception.ExceptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(UserException.class)
    public ResponseEntity<ExceptionResponse> handleUserException(UserException e) {
        return ResponseEntity.status(e.getType().getStatus())
            .body(new ExceptionResponse(e.getType().getMessage(), e.getType().getCode()));
    }
}
