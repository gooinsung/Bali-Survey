package bali.balisurvey.adapter.in.web.user.dto.response;

import bali.balisurvey.application.port.in.user.dto.result.SignInResult;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignInResponse {

    private String accessToken;

    public SignInResponse(SignInResult result) {
        this.accessToken = result.getAccessToken();
    }
}
