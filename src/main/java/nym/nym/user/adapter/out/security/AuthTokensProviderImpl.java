package nym.nym.user.adapter.out.security;

import lombok.RequiredArgsConstructor;
import nym.nym.user.domain.AuthTokens;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class AuthTokensProviderImpl implements AuthTokensProvider {
    private static final String BEARER_TYPE = "Bearer";
    private static final long ACCESS_TOKEN_EXPIRE_TIME = 2000 * 60 * 60; //2시간
    private static final long REFRESH_TOKEN_EXPIRE_TIME = 1000 * 60 * 60 * 24 * 7;//일주일
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public AuthTokens generate(String uid) {
        long now = (new Date()).getTime();
        Date accessTokenExpiredAt = new Date(now + ACCESS_TOKEN_EXPIRE_TIME);
        Date refreshTokenExpiredAt = new Date(now + REFRESH_TOKEN_EXPIRE_TIME);

        //String subject = email.toString();
        String accessToken = jwtTokenProvider.accessTokenGenerate(uid, accessTokenExpiredAt);
        String refreshToken = jwtTokenProvider.refreshTokenGenerate(refreshTokenExpiredAt);

        return AuthTokens.of(accessToken, refreshToken, BEARER_TYPE, ACCESS_TOKEN_EXPIRE_TIME / 1000L);
    }

}
