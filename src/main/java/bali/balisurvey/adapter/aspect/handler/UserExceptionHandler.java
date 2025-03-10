package bali.balisurvey.adapter.aspect.handler;

import bali.balisurvey.adapter.aspect.response.ExceptionResponse;
import bali.balisurvey.application.service.user.exception.UserException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(UserException.class)
    public ResponseEntity<ExceptionResponse> handleUserException(UserException e) {
        return ResponseEntity.status(e.getType().getStatus())
            .body(new ExceptionResponse(e.getType().getMessage()));
    }
}
