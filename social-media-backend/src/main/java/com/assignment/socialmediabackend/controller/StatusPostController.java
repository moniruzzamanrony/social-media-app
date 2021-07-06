package com.assignment.socialmediabackend.controller;


import com.assignment.socialmediabackend.constents.AuthConstent;
import com.assignment.socialmediabackend.constents.SharePostConstent;
import com.assignment.socialmediabackend.dto.request.StatusRequest;
import com.assignment.socialmediabackend.dto.response.IdentityResponse;
import com.assignment.socialmediabackend.dto.response.StatusResponse;
import com.assignment.socialmediabackend.services.StatusPostService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
@RequestMapping(AuthConstent.PRIVATE_API)
public class StatusPostController {

    private final StatusPostService statusPostService;

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping(SharePostConstent.POST_STATUS)
    public ResponseEntity<IdentityResponse> post(@RequestBody StatusRequest statusRequest) {
        return statusPostService.post(statusRequest);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping(SharePostConstent.GET_MY_STATUS)
    public ResponseEntity<List<StatusResponse>> getMyStatus() {
        return statusPostService.getMyStatus();
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PutMapping(SharePostConstent.GET_MY_STATUS_BY_ID)
    public ResponseEntity<Void> updatePost(@RequestBody StatusRequest statusRequest, @PathVariable String id) {
        return statusPostService.updateMyStatus(id, statusRequest);
    }
}
