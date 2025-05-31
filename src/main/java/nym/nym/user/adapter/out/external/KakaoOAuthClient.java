package nym.nym.user.adapter.out.external;

import java.util.HashMap;

public interface KakaoOAuthClient {
    //인가 코드로 AccessToken 요청
    String getAccessToken(String code,String redirectUri,String clientId);
    //토큰으로 카카오 API 호출
    HashMap<String,Object> getKakaoUserInfo(String accessToken);
}
