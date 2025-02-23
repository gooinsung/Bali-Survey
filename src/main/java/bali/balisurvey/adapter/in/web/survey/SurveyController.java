package bali.balisurvey.adapter.in.web.survey;

import bali.balisurvey.application.service.SurveyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class SurveyController {
    private final SurveyService service;
}
