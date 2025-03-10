package bali.balisurvey.common;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JwtProvider {

    private final Key key;
    private final long expiration;
    private final long refreshExpiration;

    public JwtProvider(@Value("${jwt.secret}") String secretKey,
        @Value("${jwt.expiration-time}") long expiration,
        @Value("${jwt.refresh-expiration-time}") long refreshExpiration) {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        this.key = Keys.hmacShaKeyFor(keyBytes);
        this.expiration = expiration;
        this.refreshExpiration = refreshExpiration;
    }


}
