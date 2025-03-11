package bali.balisurvey.adapter.out.persistence.user.repository;

import bali.balisurvey.adapter.out.persistence.user.entity.UserEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {

    Boolean existsByUserId(String userId);

    Optional<UserEntity> findByUserId(String userId);
}
