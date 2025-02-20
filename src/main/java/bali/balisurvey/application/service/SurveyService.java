package bali.balisurvey.application.service;

import bali.balisurvey.application.port.in.usecase.CreateSurveyUseCase;
import bali.balisurvey.application.port.out.SurveyPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SurveyService implements CreateSurveyUseCase {
    private final SurveyPersistencePort surveyPersistencePort;
}
