package net.accessory.hitechstore.histore.services.Impl;

import net.accessory.hitechstore.histore.entities.Token;
import net.accessory.hitechstore.histore.repositories.TokenRepository;
import net.accessory.hitechstore.histore.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private TokenRepository tokenRepository;


    @Override
    public boolean isExist(String token) {
        return tokenRepository.isExist(token);
    }

    @Override
    public void insertTokenToBlacklist(Token token) {
        tokenRepository.save(token);
    }
}
