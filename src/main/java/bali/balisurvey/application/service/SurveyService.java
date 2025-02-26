package bali.balisurvey.application.service;

import bali.balisurvey.application.port.in.dto.CreateSurveyCommand;
import bali.balisurvey.application.port.in.dto.CreateSurveyResult;
import bali.balisurvey.application.port.in.usecase.CreateSurveyUseCase;
import bali.balisurvey.application.port.out.SurveyPersistencePort;
import bali.balisurvey.domain.model.survey.Survey;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SurveyService implements CreateSurveyUseCase {
    private final SurveyPersistencePort surveyPersistencePort;

    @Override
    public CreateSurveyResult createSurvey(CreateSurveyCommand command) {
        Survey survey = surveyPersistencePort.save(command);
        return new CreateSurveyResult(survey.getSeq(), survey.getTitle(), survey.getDescription());
    }
}
