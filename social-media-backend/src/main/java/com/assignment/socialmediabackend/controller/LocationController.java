package com.assignment.socialmediabackend.controller;


import com.assignment.socialmediabackend.constents.AuthConstent;
import com.assignment.socialmediabackend.constents.LocationConstent;
import com.assignment.socialmediabackend.domain.model.Locations;
import com.assignment.socialmediabackend.dto.request.LoginForm;
import com.assignment.socialmediabackend.dto.request.SignUpForm;
import com.assignment.socialmediabackend.services.LocationService;
import com.assignment.socialmediabackend.services.SignUpAndSignInService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(AuthConstent.PUBLIC_API)
@AllArgsConstructor
public class LocationController {

    private final LocationService locationService;

    @GetMapping(LocationConstent.GET_LOCATION)
    public ResponseEntity<List<Locations>> getLocations() {

        return locationService.getLocations();
    }

}
