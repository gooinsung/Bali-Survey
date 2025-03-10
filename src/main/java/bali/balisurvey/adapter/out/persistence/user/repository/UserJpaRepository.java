package bali.balisurvey.adapter.out.persistence.user.repository;

import bali.balisurvey.adapter.out.persistence.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {

    Boolean existsByUserId(String userId);
}
