package bali.balisurvey.adapter.aspect.response;

import lombok.Getter;

@Getter
public class ExceptionResponse {

    private String message;
    private String code;

    public ExceptionResponse(String message, String code) {
        this.message = message;
        this.code = code;
    }
}
