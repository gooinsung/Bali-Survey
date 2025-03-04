package bali.balisurvey.adapter.in.web.dto.request;

import jakarta.validation.constraints.NotNull;

public record SignUpRequest(
    @NotNull(message = "UserId is required")
    String userId,
    @NotNull(message = "Password is required")
    String password,
    @NotNull(message = "Name is required")
    String name
) {

}
