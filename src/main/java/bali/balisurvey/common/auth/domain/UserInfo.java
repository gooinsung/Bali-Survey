package bali.balisurvey.common.auth.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserInfo {

    private Long seq;
    private String userId;
    private String name;
    private String password;
    private String role;
}
