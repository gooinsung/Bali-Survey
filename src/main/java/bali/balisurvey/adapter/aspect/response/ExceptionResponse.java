package bali.balisurvey.adapter.aspect.response;

import lombok.Getter;

@Getter
public class ExceptionResponse {

    private String message;

    public ExceptionResponse(String message) {
        this.message = message;
    }
}
