package bali.balisurvey.application.port.in.user.dto.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.crypto.password.PasswordEncoder;

@AllArgsConstructor
@Getter
public class SignUpCommand {

    private String userId;
    private String password;
    private String name;

    public void encryptPassword(PasswordEncoder encoder) {
        this.password = encoder.encode(this.password);
    }
}
