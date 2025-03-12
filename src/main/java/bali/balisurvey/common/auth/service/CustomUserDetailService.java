package bali.balisurvey.common.auth.service;

import bali.balisurvey.common.auth.domain.Auth;
import bali.balisurvey.common.auth.provider.UserInfoProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserInfoProvider userInfoProvider;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new Auth(userInfoProvider.findByUserId(username));
    }
}
