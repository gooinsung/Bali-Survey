package bali.balisurvey.application.port.out;

import bali.balisurvey.application.port.in.dto.CreateSurveyCommand;
import bali.balisurvey.domain.model.survey.Survey;

public interface SurveyPersistencePort {
    Survey save(CreateSurveyCommand command);
}
