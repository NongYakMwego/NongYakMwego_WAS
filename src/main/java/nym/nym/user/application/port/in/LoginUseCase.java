package nym.nym.user.application.port.in;

import nym.nym.user.adapter.in.web.LoginResponse;

public interface LoginUseCase {
    LoginResponse kakaoLogin(String code,String currentDomain);
}
