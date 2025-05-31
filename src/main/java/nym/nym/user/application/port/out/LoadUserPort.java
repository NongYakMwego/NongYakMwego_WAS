package nym.nym.user.application.port.out;

import nym.nym.user.domain.User;

import java.util.Optional;

public interface LoadUserPort {
    Optional<User> loadUserByEmail(String email);
}
