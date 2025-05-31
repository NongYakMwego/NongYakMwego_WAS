package nym.nym.user.domain;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class AuthTokens {
    private String accessToken;
    private String refreshToken;
    private String grantType;
    private Long expireIn;

    public static AuthTokens of(String accessToken, String refreshToken, String grantType, Long expireIn){
        return AuthTokens.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .grantType(grantType)
                .expireIn(expireIn)
                .build();
    }
}
