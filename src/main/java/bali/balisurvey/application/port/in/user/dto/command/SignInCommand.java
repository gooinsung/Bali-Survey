package bali.balisurvey.application.port.in.user.dto.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignInCommand {

    private String userId;
    private String password;
}
