package bali.balisurvey.application.mapper.user;

import bali.balisurvey.adapter.out.persistence.user.entity.UserEntity;
import bali.balisurvey.domain.model.user.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toDomain(UserEntity entity) {
        return new User(entity.getUserSeq(), entity.getUserId(), entity.getPassword(),
            entity.getName(), entity.getRole());
    }
}
