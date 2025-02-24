package bali.balisurvey.application.port.in.usecase;

import bali.balisurvey.application.port.in.dto.CreateSurveyCommand;
import bali.balisurvey.application.port.in.dto.CreateSurveyResult;

public interface CreateSurveyUseCase {
    CreateSurveyResult createSurvey(CreateSurveyCommand command);
}
