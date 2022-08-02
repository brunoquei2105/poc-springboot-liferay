package com.auth.serviceauthapi.api;

import com.auth.serviceauthapi.model.AuthReponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

@Validated
public interface AuthApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }


    @PostMapping(path = "/jwt-token")
    default ResponseEntity<AuthReponse> login(@RequestParam("user") String username, @RequestParam("password") String pwd) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}