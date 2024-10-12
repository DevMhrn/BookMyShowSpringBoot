package org.buildproduct.bookmyshow.services;

import org.buildproduct.bookmyshow.dtos.LoginSignUpDtos.ResponseStatus;
import org.buildproduct.bookmyshow.models.User;

public interface UserServiceInterface {
    public User signup(String name, String email, String password);

    public ResponseStatus login(String email, String password);
}
