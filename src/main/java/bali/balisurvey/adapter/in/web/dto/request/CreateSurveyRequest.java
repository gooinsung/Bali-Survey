package bali.balisurvey.adapter.in.web.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateSurveyRequest(
    @NotNull(message = "Title is required")
    String title,
    @NotBlank(message = "Description is required")
    String description) {

}
