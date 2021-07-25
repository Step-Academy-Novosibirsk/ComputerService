package ru.ipgolenischev.computerservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ipgolenischev.computerservice.models.Requests.AuthorizationRequest;
import ru.ipgolenischev.computerservice.models.Responses.AuthorizationResponse;
import ru.ipgolenischev.computerservice.models.base.AbstractServiceUserServiceModel;
import ru.ipgolenischev.computerservice.services.AuthorizationService;

@RestController
@RequestMapping("/api/authorize")
public class AuthorizationController {
    private final AuthorizationService authorizationService;
    public AuthorizationController(AuthorizationService authorizationService){
        this.authorizationService = authorizationService;
    }
    @PostMapping
    public ResponseEntity<AuthorizationResponse> authorize(@RequestBody AuthorizationRequest authorizationRequest){
        AbstractServiceUserServiceModel user = authorizationService.authorize(authorizationRequest.getPhone(),authorizationRequest.getPassword());
        if(user==null)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new AuthorizationResponse(user,"qwerty"));
    }
}
