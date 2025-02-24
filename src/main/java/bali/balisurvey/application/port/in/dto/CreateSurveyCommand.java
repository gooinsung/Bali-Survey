package bali.balisurvey.application.port.in.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateSurveyCommand(
        @NotNull(message = "Title is required")
        String title,
        @NotBlank(message = "Description is required")
        String description
) {
}
