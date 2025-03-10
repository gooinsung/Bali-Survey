package bali.balisurvey.application.service.user;

import bali.balisurvey.application.port.in.user.dto.command.SignUpCommand;
import bali.balisurvey.application.port.in.user.dto.result.SignUpResult;
import bali.balisurvey.application.port.in.user.usecase.SignUpUserCase;
import bali.balisurvey.application.port.out.user.UserPersistencePort;
import bali.balisurvey.application.service.user.exception.UserException;
import bali.balisurvey.application.service.user.exception.enums.UserExceptionType;
import bali.balisurvey.domain.model.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements SignUpUserCase {

    private final UserPersistencePort userPersistencePort;

    @Override
    public SignUpResult signUp(SignUpCommand command) {

        if (Boolean.TRUE.equals(userPersistencePort.isUserExist(command.getUserId()))) {
            throw new UserException(UserExceptionType.EXIST_USER);
        }

        User user = userPersistencePort.save(command);
        
        return new SignUpResult(user.getSeq(), user.getUserId(), user.getName());
    }
}
