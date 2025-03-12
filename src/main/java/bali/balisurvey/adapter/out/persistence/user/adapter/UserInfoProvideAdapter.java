package bali.balisurvey.adapter.out.persistence.user.adapter;

import bali.balisurvey.adapter.out.persistence.user.entity.UserEntity;
import bali.balisurvey.adapter.out.persistence.user.repository.UserJpaRepository;
import bali.balisurvey.application.service.user.exception.UserException;
import bali.balisurvey.application.service.user.exception.enums.UserExceptionType;
import bali.balisurvey.common.auth.domain.UserInfo;
import bali.balisurvey.common.auth.provider.UserInfoProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserInfoProvideAdapter implements UserInfoProvider {

    private final UserJpaRepository userJpaRepository;

    @Override
    public UserInfo findByUserId(String userId) {
        UserEntity entity = userJpaRepository.findByUserId(userId)
            .orElseThrow(() -> new UserException(
                UserExceptionType.NOT_FOUND));
        return new UserInfo(entity.getUserSeq(), entity.getUserId(), entity.getPassword(),
            entity.getName(), entity.getRole());
    }
}
