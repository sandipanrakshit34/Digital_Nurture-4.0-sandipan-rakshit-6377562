package com.cognizant.spring_learn.controller;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    @GetMapping("/authenticate")
    public Map<String, String> getAuth(@RequestHeader("Authorization") String authHeader){
        logger.info("Start");
        logger.debug("AuthHeader: {}",authHeader);
        HashMap<String, String> hmap = new HashMap<>();
        String username = getUser(authHeader);
        String token = generateJwt(username);
        hmap.put("token", token);
        hmap.put("username",username);
        logger.info("End");
        return hmap;
    }

    private String getUser(String authHeader){
        logger.info("Start");
        logger.debug("Authorization Header: {}",authHeader);
        String base64Credentials = authHeader.substring("Basic ".length());
        byte[] deb = Base64.getDecoder().decode(base64Credentials);
        String des = new String(deb);
        String username = des.split(":", 2)[0];
        logger.debug("Retrieved username: {}",username);
        logger.info("End");
        return username;
    }

    private String generateJwt(String user){
        logger.info("Start");
        Key key = Keys.hmacShaKeyFor("secretkeysecretkeysecretkey123456".getBytes(StandardCharsets.UTF_8));
        Map<String, Object> claims = new HashMap<>();
        claims.put("authorities", java.util.List.of("ROLE_USER"));

        JwtBuilder builder = Jwts.builder()
                .claims(claims)
                .subject(user)
                .issuedAt(new Date())
                .expiration(new Date((new Date()).getTime()+1200000))
                .signWith(key);
        String token = builder.compact();
        logger.info("End");
        return token;
    }


}
