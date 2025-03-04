package bali.balisurvey.application.port.in.survey.usercase;

import bali.balisurvey.application.port.in.survey.dto.command.CreateSurveyCommand;
import bali.balisurvey.application.port.in.survey.dto.result.CreateSurveyResult;

public interface CreateSurveyUseCase {

    CreateSurveyResult createSurvey(CreateSurveyCommand command);
}
