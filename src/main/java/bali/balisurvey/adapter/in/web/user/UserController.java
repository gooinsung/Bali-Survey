package bali.balisurvey.adapter.in.web.user;


import bali.balisurvey.adapter.in.web.user.dto.request.SignInRequest;
import bali.balisurvey.adapter.in.web.user.dto.request.SignUpRequest;
import bali.balisurvey.adapter.in.web.user.dto.response.SignInResponse;
import bali.balisurvey.adapter.in.web.user.dto.response.SignUpResponse;
import bali.balisurvey.application.port.in.user.dto.command.SignInCommand;
import bali.balisurvey.application.port.in.user.dto.command.SignUpCommand;
import bali.balisurvey.application.port.in.user.usecase.SignInUseCase;
import bali.balisurvey.application.port.in.user.usecase.SignUpUserCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final SignUpUserCase signUpUserCase;
    private final SignInUseCase signInUseCase;

    @PostMapping
    public ResponseEntity<SignUpResponse> signUp(
        @Valid @RequestBody SignUpRequest request) {
        SignUpCommand command = new SignUpCommand(request.userId(),
            request.password(), request.name());
        return ResponseEntity.ok(new SignUpResponse(signUpUserCase.signUp(command)));
    }

    @PostMapping("/sign-in")
    public ResponseEntity<SignInResponse> login(@Valid @RequestBody SignInRequest request) {
        SignInCommand command = new SignInCommand(request.userId(), request.password());
        return ResponseEntity.ok(new SignInResponse(signInUseCase.signIn(command)));
    }
}


