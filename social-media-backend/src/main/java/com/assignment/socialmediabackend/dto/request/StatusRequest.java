package com.assignment.socialmediabackend.dto.request;

import com.assignment.socialmediabackend.enums.PostPrivecy;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class StatusRequest {

    private String statusBody;

    private PostPrivecy postPrivecy;

    private String location;


}
