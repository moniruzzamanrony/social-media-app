package com.assignment.socialmediabackend.controller;


import com.assignment.socialmediabackend.constents.AuthConstent;
import com.assignment.socialmediabackend.constents.SharePostConstent;
import com.assignment.socialmediabackend.dto.response.StatusResponse;
import com.assignment.socialmediabackend.services.StatusPostService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
@RequestMapping(AuthConstent.PUBLIC_API)
public class PublicStatusController {

    private final StatusPostService statusPostService;

    @GetMapping(SharePostConstent.STATUS)
    public ResponseEntity<List<StatusResponse>> getStatus() {
        return statusPostService.getStatus();
    }

}
