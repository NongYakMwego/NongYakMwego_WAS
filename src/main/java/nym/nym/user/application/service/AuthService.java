package nym.nym.user.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nym.nym.user.adapter.in.web.LoginResponse;
import nym.nym.user.adapter.out.external.KakaoOAuthClient;
import nym.nym.user.adapter.out.security.AuthTokensProvider;
import nym.nym.user.application.port.in.LoginUseCase;
import nym.nym.user.application.port.out.SaveUserPort;
import nym.nym.user.domain.AuthTokens;
import nym.nym.user.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@RequiredArgsConstructor
@Slf4j
@Service
public class AuthService implements LoginUseCase {
    private final KakaoOAuthClient kakaoOAuthClient;
    private final AuthTokensProvider authTokensProvider;
    private final SaveUserPort saveUserPort;

    @Value("${kakao.client-id}")
    private String clientId;

    @Value("${kakao.redirect-uri}")
    private String redirectUri;

    @Override
    public LoginResponse kakaoLogin(String code, String currentDomain) {
        String accessToken= kakaoOAuthClient.getAccessToken(code,redirectUri,clientId);
        HashMap<String,Object> userInfo=kakaoOAuthClient.getKakaoUserInfo(accessToken);

        User user=saveUserPort.saveUser(userInfo);

        AuthTokens token= authTokensProvider.generate(String.valueOf(user.getUserId()));

        return LoginResponse.builder()
                .id(user.getUserId())
                .email(user.getUserEmail())
                .nickName(user.getUserNickName())
                .token(token)
                .build();
    }
}
