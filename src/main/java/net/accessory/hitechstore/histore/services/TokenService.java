package net.accessory.hitechstore.histore.services;

import net.accessory.hitechstore.histore.entities.Token;

public interface TokenService {
    boolean isExist(String token);
    void insertTokenToBlacklist(Token token);
}
