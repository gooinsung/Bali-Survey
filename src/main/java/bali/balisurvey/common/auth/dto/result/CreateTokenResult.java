package bali.balisurvey.common.auth.dto.result;

import lombok.Getter;

@Getter
public class CreateTokenResult {

    private String accessToken;

    public CreateTokenResult(String accessToken) {
        this.accessToken = accessToken;
    }
}
