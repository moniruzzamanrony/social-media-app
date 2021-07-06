package com.assignment.socialmediabackend.controller;


import com.assignment.socialmediabackend.constents.AuthConstent;
import com.assignment.socialmediabackend.dto.request.LoginForm;
import com.assignment.socialmediabackend.dto.request.SignUpForm;
import com.assignment.socialmediabackend.services.SignUpAndSignInService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(AuthConstent.PUBLIC_API)
@AllArgsConstructor
public class AuthController {

    private final SignUpAndSignInService signUpAndSignInService;

    @PostMapping(AuthConstent.SIGNIN_API)
    public ResponseEntity<?> authenticateUser(@RequestBody LoginForm loginRequest) {

        return ResponseEntity.ok(signUpAndSignInService.signIn(loginRequest));
    }

    @PostMapping(AuthConstent.SIGNUP_API)
    public ResponseEntity<String> registerUser(@RequestBody SignUpForm signUpRequest) {
        return signUpAndSignInService.signUp(signUpRequest);
    }

}
