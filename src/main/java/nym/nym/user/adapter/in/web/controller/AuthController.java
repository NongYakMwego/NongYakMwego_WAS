package nym.nym.user.adapter.in.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import nym.nym.user.adapter.in.web.LoginResponse;
import nym.nym.user.application.port.in.LoginUseCase;
import nym.nym.global.common.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final LoginUseCase loginUseCase;

    @ResponseBody
    @GetMapping("/login/kakao")
    public ResponseEntity<ApiResponse<LoginResponse>> kakaoLogin(@RequestParam(value = "code")String code, HttpServletRequest request){
        //현재 도메인 확인
        String currentDomain=request.getServerName();
        return ResponseEntity.ok(ApiResponse.ok(loginUseCase.kakaoLogin(code,currentDomain)));
    }
}
