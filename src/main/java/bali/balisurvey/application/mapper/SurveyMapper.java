package bali.balisurvey.application.mapper;

import bali.balisurvey.adapter.out.persistence.entity.SurveyEntity;
import bali.balisurvey.domain.model.survey.Survey;
import org.springframework.stereotype.Component;

@Component
public class SurveyMapper {

    public Survey toDomain(SurveyEntity entity) {
        return new Survey(entity.getSeq(), entity.getTitle(), entity.getDescription());
    }
}
