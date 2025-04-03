package bali.balisurvey.application.mapper.survey;

import bali.balisurvey.adapter.out.persistence.survey.entity.SurveyEntity;
import bali.balisurvey.domain.model.survey.Survey;
import org.springframework.stereotype.Component;

@Component
public class SurveyMapper {

    public Survey toDomain(SurveyEntity entity) {
        return Survey
            .builder()
            .seq(entity.getSeq())
            .title(entity.getTitle())
            .description(entity.getDescription())
            .build();
    }
}
