package bali.balisurvey.adapter.in.web.survey;

import bali.balisurvey.adapter.in.web.dto.request.CreateSurveyRequest;
import bali.balisurvey.adapter.in.web.dto.response.CreateSurveyResponse;
import bali.balisurvey.application.port.in.survey.dto.command.CreateSurveyCommand;
import bali.balisurvey.application.port.in.survey.usercase.CreateSurveyUseCase;
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

    private final CreateSurveyUseCase createSurvey;

    @PostMapping
    public ResponseEntity<CreateSurveyResponse> createSurvey(
        @RequestBody @Valid CreateSurveyRequest request) {
        CreateSurveyCommand command = new CreateSurveyCommand(request.title(),
            request.description());
        return ResponseEntity.ok(new CreateSurveyResponse(createSurvey.createSurvey(command)));
    }

}
