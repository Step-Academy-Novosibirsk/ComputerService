package ru.ipgolenischev.computerservice.models.Responses;

import ru.ipgolenischev.computerservice.models.base.AbstractServiceUserServiceModel;

public class AuthorizationResponse {
    private AbstractServiceUserServiceModel user;
    private String token;

    public AuthorizationResponse(AbstractServiceUserServiceModel user, String token) {
        this.user = user;
        this.token = token;
    }

    public AbstractServiceUserServiceModel getUser() {
        return user;
    }

    public String getToken() {
        return token;
    }
}
