package com.assignment.socialmediabackend.services;

import com.assignment.socialmediabackend.domain.model.Locations;
import com.assignment.socialmediabackend.domain.model.Status;
import com.assignment.socialmediabackend.domain.repository.LocationRepository;
import com.assignment.socialmediabackend.domain.repository.StatusRepository;
import com.assignment.socialmediabackend.dto.request.StatusRequest;
import com.assignment.socialmediabackend.dto.response.IdentityResponse;
import com.assignment.socialmediabackend.dto.response.StatusResponse;
import com.assignment.socialmediabackend.enums.PostPrivecy;
import com.assignment.socialmediabackend.exception.ResourseNotFoundException;
import com.assignment.socialmediabackend.utils.ApplicationUtils;
import com.assignment.socialmediabackend.utils.LoggedUserUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;

    public ResponseEntity<List<Locations>> getLocations() {
        return new ResponseEntity(locationRepository.findAll(),HttpStatus.OK);
    }
}
