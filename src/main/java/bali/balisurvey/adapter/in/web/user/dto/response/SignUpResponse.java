package bali.balisurvey.adapter.in.web.user.dto.response;

import bali.balisurvey.application.port.in.user.dto.result.SignUpResult;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignUpResponse {

    private Long userSeq;
    private String userId;
    private String name;

    public SignUpResponse(SignUpResult result) {
        this.userSeq = result.getSeq();
        this.userId = result.getUserId();
        this.name = result.getName();
    }
}
