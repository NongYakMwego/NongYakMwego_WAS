package nym.nym.user.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nym.nym.global.common.type.ErrorCode;
import nym.nym.global.exception.CustomException;
import nym.nym.user.application.port.out.LoadUserPort;
import nym.nym.user.application.port.out.SaveUserPort;
import nym.nym.global.common.annotaion.CustomLog;
import nym.nym.global.common.annotaion.PersistenceAdapter;
import nym.nym.user.adapter.out.persistence.mapper.UserMapper;
import nym.nym.user.domain.User;

import java.util.HashMap;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@PersistenceAdapter("userPersistenceAdapter")
public class UserPersistenceAdapter implements SaveUserPort {
    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    @CustomLog
    public User saveUser(HashMap<String, Object> userInfo) {
        // 안전한 방법으로 값 추출
        Long uid = extractLongValue(userInfo, "id");
        String nickName = extractStringValue(userInfo, "nickname");


        // 닉네임이 없는 경우 기본값 설정
        if (nickName == null || nickName.trim().isEmpty()) {
            nickName = "nickName" + uid;
        }

        UserEntity kakaoUser = userRepository.findById(uid).orElse(null);

        // 회원가입
        if (kakaoUser == null) {
            UserEntity savedUser = UserEntity
                    .builder()
                    .userId(uid)
                    .userNickName(nickName)
                    .build();
            return userMapper.entityToDomain(userRepository.save(savedUser));
        }

        return userMapper.entityToDomain(kakaoUser);
    }

    // 안전한 Long 값 추출
    @CustomLog
    private Long extractLongValue(HashMap<String, Object> map, String key) {
        Object value = map.get(key);
        if (value == null) {
            throw new CustomException(ErrorCode.EMPTY_KEY_VALUE);
        }

        try {
            if (value instanceof Long) {
                return (Long) value;
            } else if (value instanceof Number) {
                return ((Number) value).longValue();
            } else {
                return Long.parseLong(value.toString());
            }
        } catch (NumberFormatException e) {
            throw new CustomException(ErrorCode.NOT_CHANGE_VALUE);
        }
    }

    // 안전한 String 값 추출 (null 허용)
    private String extractStringValue(HashMap<String, Object> map, String key) {
        Object value = map.get(key);
        if (value == null) {
            return null;
        }
        return value.toString().trim();
    }
}