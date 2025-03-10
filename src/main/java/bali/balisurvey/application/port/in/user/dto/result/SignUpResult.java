package bali.balisurvey.application.port.in.user.dto.result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class SignUpResult {

    private Long seq;
    private String userId;
    private String name;
}
