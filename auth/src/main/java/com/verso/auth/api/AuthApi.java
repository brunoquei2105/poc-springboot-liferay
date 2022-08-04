package com.verso.auth.api;

import com.verso.auth.model.AuthReponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

@Validated
//@Api(value = "Auth")
public interface AuthApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    //@ApiOperation(value = "", nickname = "Auth", notes = "", response = AuthReponse.class, tags = {})
    @PostMapping(path = "/jwt/token")
    default ResponseEntity<AuthReponse> login(@RequestParam("user") String username, @RequestParam("password") String pwd) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}