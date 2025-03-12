package bali.balisurvey.common.auth.provider;

import bali.balisurvey.common.auth.domain.UserInfo;

public interface UserInfoProvider {
    UserInfo findByUserId(String userId);

}
