package bali.balisurvey.common.auth.jwt;

import bali.balisurvey.common.auth.dto.command.CreateJwtCommand;
import bali.balisurvey.common.auth.dto.result.CreateTokenResult;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
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
public class JwtUtils {

    private final Key key;
    private final long expiration;
    private final long refreshExpiration;

    public JwtUtils(@Value("${jwt.secret}") String secretKey,
        @Value("${jwt.expiration-time}") long expiration,
        @Value("${jwt.refresh-expiration-time}") long refreshExpiration) {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        this.key = Keys.hmacShaKeyFor(keyBytes);
        this.expiration = expiration;
        this.refreshExpiration = refreshExpiration;
    }

    public CreateTokenResult createToken(CreateJwtCommand command) {
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

        return new CreateTokenResult(accessToken);

    }

    public String getUserId(String accessToken) {
        return parseClaims(accessToken).get("userId", String.class);
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

    public Boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return Boolean.TRUE;
        } catch (SecurityException | MalformedJwtException e) {
            log.info("Invalid JWT Token", e);
        } catch (ExpiredJwtException e) {
            log.info("Expired JWT Token", e);
        } catch (UnsupportedJwtException e) {
            log.info("Unsupported JWT Token", e);
        } catch (IllegalArgumentException e) {
            log.info("JWT claims string is empty.", e);
        }
        return false;
    }


}
