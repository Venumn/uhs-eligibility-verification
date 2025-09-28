package com.uhs.eligibility.uhs_eligibility_verification.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JWTTokenProvider {

    private static final long EXPIRATION_MS =3600_00;
    private SecretKey key;

    public JWTTokenProvider(SecretKey key) {
        this.key = key;
    }

    public String generateToken(String userName) {
        Date now = new Date();
        Date expiry = new Date(now.getTime() + EXPIRATION_MS);

        return Jwts.builder().setSubject(userName).setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();


    }


}
