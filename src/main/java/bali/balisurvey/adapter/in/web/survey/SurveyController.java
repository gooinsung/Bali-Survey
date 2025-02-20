package bali.balisurvey.adapter.in.web.survey;

import bali.balisurvey.application.service.SurveyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SurveyController {
    private final SurveyService service;
}
