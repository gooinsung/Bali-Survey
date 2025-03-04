package bali.balisurvey.domain.enums.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserRole {
    NORMAL_USER("USER"),
    BUSINESS_USER("BUSINESS");
    private final String role;
}
