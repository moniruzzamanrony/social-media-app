package com.assignment.socialmediabackend.dto.request;


import com.assignment.socialmediabackend.enums.RoleName;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
public class SignUpForm {

    private String userId;

    private String name;

    private String email;

    private String phoneNo;

    private String address;

    private String username;

    private Set<RoleName> role;

    private String password;

}
