package nym.nym.user.adapter.out.persistence.mapper;

import nym.nym.user.adapter.out.persistence.UserEntity;
import nym.nym.user.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper{
    @Override
    public UserEntity domainToEntity(User user) {
        return UserEntity.builder()
                .userId(user.getUserId())
                .userNickName(user.getUserNickName())
                .build();
    }

    @Override
    public User entityToDomain(UserEntity user) {
        return User.builder()
                .userId(user.getUserId())
                .userNickName(user.getUserNickName())
                .build();
    }
}
