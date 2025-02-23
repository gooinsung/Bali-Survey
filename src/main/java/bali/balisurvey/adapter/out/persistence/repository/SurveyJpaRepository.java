package bali.balisurvey.adapter.out.persistence.repository;

import bali.balisurvey.domain.model.survey.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyJpaRepository extends JpaRepository<Survey, Long> {
}
