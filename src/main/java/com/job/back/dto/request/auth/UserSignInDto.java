package com.job.back.dto.request.auth;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserSignInDto {
    @NotBlank
    @Email
<<<<<<< HEAD
    @Length(max = 45)
=======
    @Length(max = 30)
>>>>>>> a8c9f25f7e199a62a896193ced62aa0686ea6dd9
    private String userEmail;
    @NotBlank
    @Length(min = 8, max = 50)
    private String userPassword;
}
