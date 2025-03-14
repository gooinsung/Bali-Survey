package bali.balisurvey.common.config;

import bali.balisurvey.common.auth.handler.JwtAccessDeniedHandler;
import bali.balisurvey.common.auth.handler.JwtAuthenticationEntryPoint;
import bali.balisurvey.common.auth.jwt.JwtUtils;
import bali.balisurvey.common.auth.service.CustomUserDetailService;
import bali.balisurvey.common.filter.JwtAuthFilter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

    private static final String[] WHITE_LIST = {
        "/api/v1/user/**"
    };

    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    private final CustomUserDetailService customUserDetailService;
    private final JwtUtils jwtUtils;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // CSRF, CORS
        http.csrf(AbstractHttpConfigurer::disable);
        http.cors(Customizer.withDefaults());

        // 세션 stateless
        http.sessionManagement(sessionManagement -> sessionManagement
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        // formLogin BasicHttp 비활성화
        http.formLogin(AbstractHttpConfigurer::disable);
        http.httpBasic(AbstractHttpConfigurer::disable);

        // JwtAuthFilter 추가
        http.addFilterBefore(new JwtAuthFilter(customUserDetailService, jwtUtils),
                UsernamePasswordAuthenticationFilter.class)
            .exceptionHandling(exceptionHandling -> {
                exceptionHandling.accessDeniedHandler(jwtAccessDeniedHandler);
                exceptionHandling.authenticationEntryPoint(jwtAuthenticationEntryPoint);
            });

        http.authorizeHttpRequests(authorizeRequests ->
            authorizeRequests
                .requestMatchers(WHITE_LIST).permitAll()
                .anyRequest().authenticated()
        );

        return http.build();
    }

    /* security 무효화 설정 */
    /*@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorizeRequests ->
                authorizeRequests.anyRequest().permitAll()
            )
            .csrf(csrf -> csrf.disable());

        return http.build();
    }*/
}
