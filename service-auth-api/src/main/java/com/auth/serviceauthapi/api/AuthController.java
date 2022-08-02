package com.auth.serviceauthapi.api;

import com.auth.serviceauthapi.model.AuthReponse;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AuthController implements AuthApi{

    private static final String BEARER = "Bearer";

    @Value("${spring.security.id}")
    private String securityId;

    @Value("${spring.security.user.name}")
    private String securityUserName;

    @Value("${spring.security.user.password}")
    private String securityUserPassword;

    @Value("${spring.security.expiration}")
    private int securityExpiration;

    @Value("${spring.security.key}")
    private String securityKey;

    @Override
    public ResponseEntity<AuthReponse> login(String username, String pwd){

        if (username.equals(securityUserName) && pwd.equals(securityUserPassword)) {
            String token = getJWTToken(username);
            AuthReponse user = new AuthReponse();
            user.setUserName(username);
            user.setExpiresIn(securityExpiration);
            user.setToken(token);
            user.setTokenType(BEARER);

            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    private String getJWTToken(String username){
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

        return Jwts.builder().setId(securityId).setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + securityExpiration))
                .signWith(SignatureAlgorithm.HS512, securityKey.getBytes()).compact();
    }
}
