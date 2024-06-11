package com.movies.IT355_Projekat.security.tools;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

public class JwtDecoder {

    private static final String SECRET_KEY = "Tz-4tHQ7jawoYVieH3GiXOFpsFaRUYLKVqPG5u-Q-iM"; // Replace with your actual secret key

    private static Key getKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    public static String getSubject(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

}
