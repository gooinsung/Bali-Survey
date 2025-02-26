package bali.balisurvey.adapter.out.persistence.adapter;

import bali.balisurvey.adapter.out.persistence.entity.SurveyEntity;
import bali.balisurvey.adapter.out.persistence.repository.SurveyJpaRepository;
import bali.balisurvey.application.mapper.SurveyMapper;
import bali.balisurvey.application.port.in.dto.CreateSurveyCommand;
import bali.balisurvey.application.port.out.SurveyPersistencePort;
import bali.balisurvey.domain.model.survey.Survey;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SurveyPersistenceAdapter implements SurveyPersistencePort {

    private final SurveyJpaRepository surveyJpaRepository;
    private final SurveyMapper surveyMapper;

    @Override
    public Survey save(CreateSurveyCommand command) {
        SurveyEntity entity = surveyJpaRepository.save(new SurveyEntity(command.title(), command.description()));
        return surveyMapper.toDomain(entity);
    }
}
