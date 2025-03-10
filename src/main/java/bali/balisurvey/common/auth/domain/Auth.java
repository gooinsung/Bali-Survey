package bali.balisurvey.common.auth.domain;

import io.jsonwebtoken.Claims;
import java.util.Collection;
import java.util.List;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Getter
public class Auth implements UserDetails {

    private String userId;
    private Long userSeq;

    public Auth(Claims claims) {
        this.userId = claims.get("userId", String.class);
        this.userSeq = claims.get("userSeq", Long.class);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return "";
    }
}
