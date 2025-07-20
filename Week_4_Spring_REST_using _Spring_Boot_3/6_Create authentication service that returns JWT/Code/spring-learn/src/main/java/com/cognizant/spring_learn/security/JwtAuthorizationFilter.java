package com.cognizant.spring_learn.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.PublicKey;
import java.util.ArrayList;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {
    private static final Logger logger = LoggerFactory.getLogger(JwtAuthorizationFilter.class);

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager){
        super(authenticationManager);
        logger.info("Start");
        logger.debug("{}",authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
    throws IOException, ServletException
    {
        logger.info("Start");
        String header = req.getHeader("Authorization");
        logger.debug(header);
        if(header==null || !header.startsWith("Bearer ")){
            chain.doFilter(req,res);
            return;
        }
        UsernamePasswordAuthenticationToken authentication = getAuthentication(req);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(req,res);
        logger.info("End");
    }

//    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
//        String token = request.getHeader("Authorization");
//        if (token != null) {
//            Jws<Claims> jws;
//            Key key = Keys.hmacShaKeyFor("secretkeysecretkeysecretkey123456".getBytes(StandardCharsets.UTF_8));
//            try{
//                JwtParser jwtParser = Jwts.parser()
//                        .setSigningKey(key)
//                        .build();
//                jws = jwtParser.parseSignedClaims(token.replace("Bearer ",""));
//                String user = jws.getPayload().getSubject();
//
//                logger.debug("User: {}",user);
//                if (user != null){
//                    return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
//                }
//            }catch (JwtException e){
//                return null;
//            }
//            return null;
//        }
//        return null;
//    }
private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
    String token = request.getHeader("Authorization");
    if (token != null && token.startsWith("Bearer ")) {
        try {
            String jwt = token.replace("Bearer ", "");
            SecretKey key = Keys.hmacShaKeyFor("secretkeysecretkeysecretkey123456".getBytes(StandardCharsets.UTF_8));

            Claims claims = Jwts.parser()
                    .setSigningKey(key)
                    .build()
                    .parseSignedClaims(jwt)
                    .getPayload();

            String user = claims.getSubject();
            var roles = claims.get("authorities", java.util.List.class); // roles = ["ROLE_USER"]

            var authorities = new ArrayList<org.springframework.security.core.authority.SimpleGrantedAuthority>();
            if (roles != null) {
                for (Object role : roles) {
                    authorities.add(new org.springframework.security.core.authority.SimpleGrantedAuthority((String) role));
                }
            }

            if (user != null) {
                return new UsernamePasswordAuthenticationToken(user, null, authorities); // ✅ pass roles here
            }
        } catch (JwtException e) {
            logger.error("Invalid JWT: {}", e.getMessage());
            return null;
        }
    }
    return null;
}
}
