package com.dio.security.jwt.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JwtService {

    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String ROLES_AUTHORIZATION = "Roles";

    @Autowired
    private JwtProperties jwtProperties;

    private SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(jwtProperties.getKey().getBytes());
    }

    public String createToken(JWTObject jwtObject) {
        Date now = new Date();
        Date validity = new Date(now.getTime() + jwtProperties.getExpiration());

        String token = Jwts.builder()
                .subject(jwtObject.getSubject())
                .issuedAt(now)
                .expiration(validity)
                .claim(ROLES_AUTHORIZATION, checkRoles(jwtObject.getRoles()))
                .signWith(getSecretKey())
                .compact();

        return jwtProperties.getPrefix() + " " + token;
    }

    public JWTObject validateAndExtractToken(String token) throws JwtException {
        String prefix = jwtProperties.getPrefix();
        if (token.startsWith(prefix)) {
            token = token.replace(prefix, "").trim();
        }

        Claims claims = Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

        JWTObject object = new JWTObject();
        object.setSubject(claims.getSubject());
        object.setExpiresAt(claims.getExpiration());
        object.setIssuedAt(claims.getIssuedAt());
        object.setRoles((List<String>) claims.get(ROLES_AUTHORIZATION));

        return object;
    }

    private List<String> checkRoles(List<String> roles) {
        return roles.stream()
                .map(s -> "ROLE_".concat(s.replace("ROLE_", "")))
                .collect(Collectors.toCollection(LinkedList::new));
    }
}
