package bali.balisurvey.common.auth.provider;

import bali.balisurvey.common.auth.domain.Auth;
import bali.balisurvey.common.auth.dto.command.CreateJwtCommand;
import bali.balisurvey.common.auth.dto.result.TokenResult;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.time.ZonedDateTime;
import java.util.Date;
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

    public TokenResult createToken(CreateJwtCommand command) {
        Claims claims = Jwts.claims();
        claims.put("userSeq", command.userSeq());
        claims.put("userId", command.userId());
        claims.put("name", command.name());
        claims.put("role", command.role());

        ZonedDateTime now = ZonedDateTime.now();
        ZonedDateTime accessTokenValidity = now.plusSeconds(expiration);

        String accessToken = Jwts
            .builder()
            .setClaims(claims)
            .setIssuedAt(Date.from(now.toInstant()))
            .setExpiration(Date.from(accessTokenValidity.toInstant()))
            .signWith(key, SignatureAlgorithm.HS256)
            .compact();

        return new TokenResult(accessToken);

    }

    public Auth getAuth(String accessToken) {
        Claims claims = parseClaims(accessToken);
        return new Auth(claims);
    }

    public Claims parseClaims(String accessToken) {
        try {
            return Jwts
                .parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(accessToken)
                .getBody();
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }


}
