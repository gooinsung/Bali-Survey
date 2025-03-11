package bali.balisurvey.adapter.out.persistence.user.adapter;

import bali.balisurvey.adapter.out.persistence.user.entity.UserEntity;
import bali.balisurvey.adapter.out.persistence.user.repository.UserJpaRepository;
import bali.balisurvey.application.mapper.user.UserMapper;
import bali.balisurvey.application.port.in.user.dto.command.SignUpCommand;
import bali.balisurvey.application.port.out.user.UserPersistencePort;
import bali.balisurvey.application.service.user.exception.UserException;
import bali.balisurvey.application.service.user.exception.enums.UserExceptionType;
import bali.balisurvey.domain.enums.user.UserRole;
import bali.balisurvey.domain.model.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserPersistencePort {

    private final UserJpaRepository userJpaRepository;
    private final UserMapper userMapper;

    @Override
    public User save(SignUpCommand command) {
        UserEntity entity = userJpaRepository.save(
            new UserEntity(command.getUserId(), command.getPassword(), command.getName(),
                UserRole.NORMAL_USER.getRole()));
        return userMapper.toDomain(entity);
    }

    @Override
    public Boolean isUserExist(String userId) {
        return userJpaRepository.existsByUserId(userId);
    }

    @Override
    public User findByUserId(String userId) {
        UserEntity entity = userJpaRepository.findByUserId(userId)
            .orElseThrow(() -> new UserException(UserExceptionType.NOT_FOUND));
        return userMapper.toDomain(entity);
    }
}
