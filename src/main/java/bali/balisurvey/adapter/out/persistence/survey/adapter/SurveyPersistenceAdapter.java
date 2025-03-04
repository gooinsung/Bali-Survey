package bali.balisurvey.adapter.out.persistence.survey.adapter;

import bali.balisurvey.adapter.out.persistence.survey.entity.SurveyEntity;
import bali.balisurvey.adapter.out.persistence.survey.repository.SurveyJpaRepository;
import bali.balisurvey.application.mapper.survey.SurveyMapper;
import bali.balisurvey.application.port.in.survey.dto.command.CreateSurveyCommand;
import bali.balisurvey.application.port.out.survey.SurveyPersistencePort;
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
        SurveyEntity entity = surveyJpaRepository.save(
            new SurveyEntity(command.getTitle(), command.getDescription()));
        return surveyMapper.toDomain(entity);
    }
}
