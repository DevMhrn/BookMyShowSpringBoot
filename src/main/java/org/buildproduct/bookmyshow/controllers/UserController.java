package org.buildproduct.bookmyshow.controllers;

import org.buildproduct.bookmyshow.dtos.LoginSignUpDtos.*;
import org.buildproduct.bookmyshow.dtos.LoginSignUpDtos.ResponseStatus;
import org.buildproduct.bookmyshow.models.User;
import org.buildproduct.bookmyshow.services.UserServiceInterface;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserServiceInterface userService;
    public UserController(UserServiceInterface userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public SignupResponseDto signup(@RequestBody SignupRequestDto signupRequestDto) {

        User user = userService.signup(
            signupRequestDto.getName(),
            signupRequestDto.getEmail(),
            signupRequestDto.getPassword()
        );
        SignupResponseDto signupResponseDto = new SignupResponseDto();
        signupResponseDto.setEmail(user.getEmail());
        signupResponseDto.setStatus(ResponseStatus.SUCCESS);
        signupResponseDto.setId(user.getId());




        return signupResponseDto;
    }
    @GetMapping("/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto requestDto){

        ResponseStatus responseStatus = userService.login(requestDto.getEmail(), requestDto.getPassword());

        LoginResponseDto loginResponseDto = new LoginResponseDto();
        loginResponseDto.setStatus(responseStatus);
        return loginResponseDto;
    }
}
