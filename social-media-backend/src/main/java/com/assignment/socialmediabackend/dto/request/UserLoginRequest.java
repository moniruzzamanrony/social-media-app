package com.assignment.socialmediabackend.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginRequest {

    private String employeeId;
    private String password;

}
