package nym.nym.user.adapter.out.security;

import nym.nym.user.domain.AuthTokens;

public interface AuthTokensProvider {
    AuthTokens generate(String uid);
}
