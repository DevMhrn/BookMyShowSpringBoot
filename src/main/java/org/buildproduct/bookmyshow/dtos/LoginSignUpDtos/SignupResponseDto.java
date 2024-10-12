package org.buildproduct.bookmyshow.dtos.LoginSignUpDtos;

import lombok.Getter;
import lombok.Setter;
import org.buildproduct.bookmyshow.dtos.ResponseStatus;

@Getter
@Setter
public class SignupResponseDto {
    private Long id;
    private String email;
    private ResponseStatus status;
}
