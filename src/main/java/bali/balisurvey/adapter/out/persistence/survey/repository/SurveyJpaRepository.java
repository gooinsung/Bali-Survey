package bali.balisurvey.adapter.out.persistence.survey.repository;

import bali.balisurvey.adapter.out.persistence.survey.entity.SurveyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyJpaRepository extends JpaRepository<SurveyEntity, Long> {

}
