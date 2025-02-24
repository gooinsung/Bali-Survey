package bali.balisurvey.adapter.in.web.survey;

import bali.balisurvey.adapter.mapper.SurveyMapper;
import bali.balisurvey.application.port.in.dto.CreateSurveyCommand;
import bali.balisurvey.application.port.in.dto.CreateSurveyResult;
import bali.balisurvey.application.service.SurveyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/survey")
@RequiredArgsConstructor
public class SurveyController {
    private final SurveyService service;

    @PostMapping
    public ResponseEntity<CreateSurveyResult> createSurvey(@RequestBody @Valid CreateSurveyCommand request) {
        return ResponseEntity.ok(service.createSurvey(request));
    }

}
