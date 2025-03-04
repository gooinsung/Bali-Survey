package bali.balisurvey.application.port.out.survey;

import bali.balisurvey.application.port.in.survey.dto.command.CreateSurveyCommand;
import bali.balisurvey.domain.model.survey.Survey;

public interface SurveyPersistencePort {

    Survey save(CreateSurveyCommand command);
}
