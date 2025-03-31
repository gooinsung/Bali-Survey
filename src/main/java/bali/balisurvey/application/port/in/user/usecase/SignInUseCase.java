package bali.balisurvey.application.port.in.user.usecase;

import bali.balisurvey.application.port.in.user.dto.command.SignInCommand;
import bali.balisurvey.application.port.in.user.dto.result.SignInResult;

public interface SignInUseCase {

    SignInResult signIn(SignInCommand command);
}
