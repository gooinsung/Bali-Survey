package bali.balisurvey.application.service.survey;

import bali.balisurvey.application.port.in.survey.dto.command.CreateSurveyCommand;
import bali.balisurvey.application.port.in.survey.dto.result.CreateSurveyResult;
import bali.balisurvey.application.port.in.survey.usercase.CreateSurveyUseCase;
import bali.balisurvey.application.port.out.survey.SurveyPersistencePort;
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
