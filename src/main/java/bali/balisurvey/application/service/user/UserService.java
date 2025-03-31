package bali.balisurvey.application.service.user;

import bali.balisurvey.application.port.in.user.dto.command.SignInCommand;
import bali.balisurvey.application.port.in.user.dto.command.SignUpCommand;
import bali.balisurvey.application.port.in.user.dto.result.SignInResult;
import bali.balisurvey.application.port.in.user.dto.result.SignUpResult;
import bali.balisurvey.application.port.in.user.usecase.SignInUseCase;
import bali.balisurvey.application.port.in.user.usecase.SignUpUserCase;
import bali.balisurvey.application.port.out.user.UserPersistencePort;
import bali.balisurvey.application.service.user.exception.UserException;
import bali.balisurvey.application.service.user.exception.enums.UserExceptionType;
import bali.balisurvey.common.auth.dto.command.CreateJwtCommand;
import bali.balisurvey.common.auth.dto.result.CreateTokenResult;
import bali.balisurvey.common.auth.jwt.JwtUtils;
import bali.balisurvey.domain.model.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements SignUpUserCase, SignInUseCase {

    private final UserPersistencePort userPersistencePort;
    private final PasswordEncoder encoder;
    private final JwtUtils jwtUtils;

    @Override
    public SignUpResult signUp(SignUpCommand command) {

        if (Boolean.TRUE.equals(userPersistencePort.isUserExist(command.getUserId()))) {
            throw new UserException(UserExceptionType.EXIST_USER);
        }

        command.encryptPassword(encoder);

        User user = userPersistencePort.save(command);

        return new SignUpResult(user.getSeq(), user.getUserId(), user.getName());
    }

    @Override
    public SignInResult signIn(SignInCommand command) {
        User user = userPersistencePort.findByUserId(command);

        if (Boolean.FALSE.equals(encoder.matches(command.getPassword(), user.getPassword()))) {
            throw new UserException(UserExceptionType.WRONG_PASSWORD);
        } else if (Boolean.TRUE.equals(user.getIsDeleted())) {
            throw new UserException(UserExceptionType.DELETED_USER);
        }

        CreateJwtCommand createJwtCommand = new CreateJwtCommand(user.getUserId(), user.getName(),
            user.getRole(), user.getSeq());

        CreateTokenResult createTokenResult = jwtUtils.createToken(createJwtCommand);

        return new SignInResult(createTokenResult.getAccessToken());
    }
}
