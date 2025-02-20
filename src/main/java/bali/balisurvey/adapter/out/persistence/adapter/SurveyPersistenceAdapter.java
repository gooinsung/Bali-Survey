package bali.balisurvey.adapter.out.persistence.adapter;

import bali.balisurvey.adapter.out.persistence.repository.SurveyJpaRepository;
import bali.balisurvey.application.port.out.SurveyPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SurveyPersistenceAdapter implements SurveyPersistencePort {

    private final SurveyJpaRepository surveyJpaRepository;
}
