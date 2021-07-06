package com.assignment.socialmediabackend.services;


import com.assignment.socialmediabackend.domain.model.Role;
import com.assignment.socialmediabackend.domain.model.User;
import com.assignment.socialmediabackend.domain.repository.RoleRepository;
import com.assignment.socialmediabackend.domain.repository.UserRepository;
import com.assignment.socialmediabackend.dto.request.LoginForm;
import com.assignment.socialmediabackend.dto.request.SignUpForm;
import com.assignment.socialmediabackend.dto.response.JwtResponse;
import com.assignment.socialmediabackend.enums.RoleName;
import com.assignment.socialmediabackend.exception.ResourseNotFoundException;
import com.assignment.socialmediabackend.security.jwt.JwtProvider;
import com.assignment.socialmediabackend.security.services.UserPrinciple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class SignUpAndSignInService {

    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JwtProvider jwtProvider;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    private UserPrinciple userPrinciple;

    public ResponseEntity<String> signUp(SignUpForm signUpRequest) {

        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity<String>("Fail -> Username is already taken!",
                    HttpStatus.BAD_REQUEST);
        }


        // Creating user's account
        User user = new User();

        Set<RoleName> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();
        strRoles.forEach(role -> {
            switch (role) {
                case ROLE_USER:
                    Role adminRole = roleRepository.findByName(RoleName.ROLE_USER)
                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                    roles.add(adminRole);
                    break;
                default:
                    throw new ResourseNotFoundException("User Role Not Match");
            }
        });

        user.setId(signUpRequest.getUserId());
        user.setUsername(signUpRequest.getUsername());
        user.setName(signUpRequest.getName());
        user.setPhoneNo(signUpRequest.getPhoneNo());
        user.setEmail(signUpRequest.getEmail());
        user.setAddress(signUpRequest.getAddress());
        user.setPassword(encoder.encode(signUpRequest.getPassword()));
        user.setRoles(roles);
        userRepository.save(user);

        return new ResponseEntity<String>(signUpRequest.getUserId(), HttpStatus.OK);
    }

    public JwtResponse signIn(LoginForm loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);
        return new JwtResponse(jwt);
    }

}
