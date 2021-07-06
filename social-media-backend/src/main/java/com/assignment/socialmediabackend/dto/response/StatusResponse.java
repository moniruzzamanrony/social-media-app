package com.assignment.socialmediabackend.dto.response;

import com.assignment.socialmediabackend.enums.PostPrivecy;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
public class StatusResponse {

    private String id;

    private String statusBody;

    private PostPrivecy postPrivecy;

    private String location;

    private LocalDateTime creationTimestamp;

    private String ownerName;


}
