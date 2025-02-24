package bali.balisurvey.adapter.mapper;

import bali.balisurvey.adapter.out.persistence.entity.SurveyEntity;
import bali.balisurvey.application.port.in.dto.CreateSurveyCommand;
import bali.balisurvey.domain.model.survey.Survey;

public class SurveyMapper {

    public static SurveyEntity toEntity(CreateSurveyCommand command) {
        return new SurveyEntity(command.title(), command.description());
    }

    public static Survey toDomain(SurveyEntity survey) {
        return new Survey(survey.getSeq(), survey.getTitle(), survey.getDescription());
    }

}
