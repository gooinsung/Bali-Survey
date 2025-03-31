package bali.balisurvey.adapter.in.web.user.dto.request;

import jakarta.validation.constraints.NotNull;

public record SignInRequest(
    @NotNull(message = "UserId is required")
    String userId,
    @NotNull(message = "Password is required")
    String password
) {

}
