package bali.balisurvey.application.service;

import bali.balisurvey.application.port.in.dto.CreateSurveyCommand;
import bali.balisurvey.application.port.in.dto.CreateSurveyResult;
import bali.balisurvey.application.port.in.usecase.CreateSurveyUseCase;
import bali.balisurvey.application.port.out.SurveyPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SurveyService implements CreateSurveyUseCase {
    private final SurveyPersistencePort surveyPersistencePort;

    @Override
    public CreateSurveyResult createSurvey(CreateSurveyCommand command) {
        return new CreateSurveyResult(surveyPersistencePort.save(command));
    }
}
