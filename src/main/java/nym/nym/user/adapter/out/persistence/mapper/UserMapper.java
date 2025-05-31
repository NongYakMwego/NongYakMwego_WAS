package nym.nym.user.adapter.out.persistence.mapper;

import nym.nym.user.adapter.out.persistence.UserEntity;
import nym.nym.user.domain.User;

public interface UserMapper {
    UserEntity domainToEntity(User user);
    User entityToDomain(UserEntity user);

}
