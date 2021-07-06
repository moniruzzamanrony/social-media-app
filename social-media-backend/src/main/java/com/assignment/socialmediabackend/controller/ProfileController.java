package com.assignment.socialmediabackend.controller;


import com.assignment.socialmediabackend.constents.AuthConstent;
import com.assignment.socialmediabackend.domain.model.User;
import com.assignment.socialmediabackend.dto.request.LoginForm;
import com.assignment.socialmediabackend.dto.request.SignUpForm;
import com.assignment.socialmediabackend.services.SignUpAndSignInService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(AuthConstent.PRIVATE_API)
@AllArgsConstructor
public class ProfileController {

    private final SignUpAndSignInService signUpAndSignInService;

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping(AuthConstent.GET_PROFILE_API)
    public ResponseEntity<User> getProfile() {
        return signUpAndSignInService.getProfile();
    }


}
