package bali.balisurvey.application.port.out.user;

import bali.balisurvey.application.port.in.user.dto.command.SignInCommand;
import bali.balisurvey.application.port.in.user.dto.command.SignUpCommand;
import bali.balisurvey.domain.model.user.User;

public interface UserPersistencePort {

    User save(SignUpCommand command);

    Boolean isUserExist(String userId);

    User findByUserId(SignInCommand command);


}
