package nym.nym.user.adapter.out.external;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import nym.nym.global.common.type.ErrorCode;
import nym.nym.global.exception.CustomException;
import org.apache.commons.collections4.MultiValuedMap;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Slf4j
@Component
public class KakaoOAuthClientImpl implements KakaoOAuthClient {

    @Override
    public String getAccessToken(String code, String redirectUri, String clientId) {
        // HTTP Header 생성
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        // HTTP Body 생성
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", "authorization_code");
        body.add("client_id", clientId);
        body.add("redirect_uri", redirectUri);
        body.add("code", code);

        // HTTP 요청 보내기
        HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = new HttpEntity<>(body, headers);
        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response = rt.exchange(
                "https://kauth.kakao.com/oauth/token",
                HttpMethod.POST,
                kakaoTokenRequest,
                String.class
        );

        // HTTP 응답 (JSON) -> 액세스 토큰 파싱
        String responseBody = response.getBody();

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = null;
        try {
            jsonNode = objectMapper.readTree(responseBody);
        } catch (JsonProcessingException e) {
            throw new CustomException(ErrorCode.FAIL_KAKAO_TOKEN_PARSING);
        }

        // null 체크 추가
        JsonNode accessTokenNode = jsonNode.get("access_token");
        if (accessTokenNode == null) {
            throw new CustomException(ErrorCode.NOT_FIND_KAKAO_ACCESS_TOKEN);
        }

        return accessTokenNode.asText();
    }

    @Override
    public HashMap<String, Object> getKakaoUserInfo(String accessToken) {
        HashMap<String, Object> userInfo = new HashMap<>();

        //HTTP Header 생성
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + accessToken);
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        //HTTP 요청 보내기
        HttpEntity<MultiValuedMap<String, String>> kakaoUserInfoRequest = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(
                "https://kapi.kakao.com/v2/user/me",
                HttpMethod.POST,
                kakaoUserInfoRequest,
                String.class
        );

        //responseBody에 있는 정보 추출
        String responseBody = response.getBody();
        log.info("Kakao user info response: {}", responseBody); // 응답 로그 추가

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = null;
        try {
            jsonNode = objectMapper.readTree(responseBody);
        } catch (JsonProcessingException e) {
            throw new CustomException(ErrorCode.FAIL_KAKAO_TOKEN_PARSING);
        }

        // 안전한 필드 추출 (null 체크 포함)
        Long id =jsonNode.asLong();
        String nickName = jsonNode.asText();

        // null 값 체크 후 저장
        userInfo.put("id", id);
        if (nickName != null) {
            userInfo.put("nickname", nickName);
        }

        return userInfo;
    }

}