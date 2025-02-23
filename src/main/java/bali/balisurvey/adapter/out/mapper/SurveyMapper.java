package bali.balisurvey.adapter.out.mapper;

import bali.balisurvey.adapter.out.persistence.entity.SurveyEntity;
import bali.balisurvey.application.port.in.dto.CreateSurveyCommand;
import bali.balisurvey.domain.model.survey.Survey;

public class SurveyMapper {

    public static SurveyEntity toEntity(CreateSurveyCommand command) {
        return new SurveyEntity(command.getTitle(), command.getDescription());
    }

    public static Survey toDomain(SurveyEntity entity){
        return new Survey(entity.getSeq(), entity.getTitle(), entity.getDescription());
    }
}
