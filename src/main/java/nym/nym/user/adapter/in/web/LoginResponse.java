package nym.nym.user.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nym.nym.user.domain.AuthTokens;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class LoginResponse {
    private Long id;
    private String nickName;
    private String email;
    private AuthTokens token;

}
