package bali.balisurvey.adapter.out.persistence.repository;

import bali.balisurvey.adapter.out.persistence.entity.SurveyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyJpaRepository extends JpaRepository<SurveyEntity, Long> {
}
