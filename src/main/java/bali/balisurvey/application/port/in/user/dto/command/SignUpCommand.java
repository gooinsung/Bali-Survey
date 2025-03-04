package bali.balisurvey.application.port.in.user.dto.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SignUpCommand {

    private String userId;
    private String password;
    private String name;
}
