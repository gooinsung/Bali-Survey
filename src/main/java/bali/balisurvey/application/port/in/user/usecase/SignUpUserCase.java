package bali.balisurvey.application.port.in.user.usecase;

import bali.balisurvey.application.port.in.user.dto.command.SignUpCommand;
import bali.balisurvey.application.port.in.user.dto.result.SignUpResult;

public interface SignUpUserCase {
    SignUpResult signUp(SignUpCommand command);

}
