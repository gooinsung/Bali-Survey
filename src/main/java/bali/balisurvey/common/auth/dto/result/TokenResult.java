package bali.balisurvey.common.auth.dto.result;

import lombok.Getter;

@Getter
public class TokenResult {
    private String accessToken;

    public TokenResult(String accessToken){
        this.accessToken = accessToken;
    }
}
