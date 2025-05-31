package nym.nym.user.application.port.out;

import nym.nym.user.domain.User;

import java.util.HashMap;

public interface SaveUserPort {
    User saveUser(HashMap<String,Object> userInfo);
}
