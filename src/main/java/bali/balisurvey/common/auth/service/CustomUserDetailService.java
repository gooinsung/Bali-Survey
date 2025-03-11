package bali.balisurvey.common.auth.service;

import bali.balisurvey.application.port.out.user.UserPersistencePort;
import bali.balisurvey.common.auth.domain.Auth;
import bali.balisurvey.common.auth.domain.UserInfo;
import bali.balisurvey.domain.model.user.User;
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

    private final UserPersistencePort userPersistencePort;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userPersistencePort.findByUserId(username);
        UserInfo userInfo = new UserInfo(user.getSeq(), user.getUserId(),
            user.getPassword(),
            user.getName(), user.getRole());
        return new Auth(userInfo);
    }
}
