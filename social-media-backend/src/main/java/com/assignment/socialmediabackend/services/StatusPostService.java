package com.assignment.socialmediabackend.services;

import com.assignment.socialmediabackend.domain.model.Status;
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
public class StatusPostService {

    private final StatusRepository statusRepository;
    private final SignUpAndSignInService signUpAndSignInService;

    public ResponseEntity<IdentityResponse> post(StatusRequest statusRequest) {
        String uuid = ApplicationUtils.getUuid();
        try {
            Status status = new Status();
            status.setId(uuid);
            status.setCreatedBy(LoggedUserUtils.username);
            status.setUpdatedBy(LoggedUserUtils.username);
            status.setStatusBody(statusRequest.getStatusBody());
            status.setPostPrivecy(statusRequest.getPostPrivecy());
            status.setLocation(statusRequest.getLocation());
            statusRepository.saveAndFlush(status);
            System.out.println(statusRequest);
            return new ResponseEntity(new IdentityResponse(uuid), HttpStatus.OK);
        } catch (Exception exception) {
            throw exception;
        }

    }

    public ResponseEntity<List<StatusResponse>> getMyStatus() {
        List<Status> statusList = statusRepository.findAllUserName(LoggedUserUtils.username);
        List<StatusResponse> statusResponseList = new ArrayList<>();

        statusList.stream().forEach(res -> {
            StatusResponse statusResponse = new StatusResponse();
            statusResponse.setOwnerName(LoggedUserUtils.name);
            BeanUtils.copyProperties(res, statusResponse);
            statusResponseList.add(statusResponse);
        });
        return new ResponseEntity(statusResponseList, HttpStatus.OK);
    }

    public ResponseEntity<List<StatusResponse>> getStatus() {
        List<Status> statusList = statusRepository.findAll();
        List<StatusResponse> statusResponseList = new ArrayList<>();

        statusList.stream().forEach(res -> {
            if (res.getPostPrivecy().equals(PostPrivecy.PUBLIC)) {
                StatusResponse statusResponse = new StatusResponse();
                statusResponse.setOwnerName(signUpAndSignInService.getDetailsById(res.getCreatedBy()).getName());
                BeanUtils.copyProperties(res, statusResponse);
                statusResponseList.add(statusResponse);
            }
        });
        return new ResponseEntity(statusResponseList, HttpStatus.OK);
    }

    public ResponseEntity<Void> updateMyStatus(String id, StatusRequest statusRequest) {

        Optional<Status> statusOptional = statusRepository.findById(id);
        if(statusOptional.isEmpty())
        {
            throw new ResourseNotFoundException("Status Not Found");
        }
        Status status= statusOptional.get();
        status.setUpdatedBy(LoggedUserUtils.username);
        status.setStatusBody(statusRequest.getStatusBody());
        status.setPostPrivecy(statusRequest.getPostPrivecy());
        status.setLocation(statusRequest.getLocation());
        statusRepository.saveAndFlush(status);
        return new ResponseEntity(HttpStatus.OK);
    }

    public ResponseEntity<Status> getStatusById(String id) {
      Optional<Status> statusOptional=  statusRepository.findById(id);
      if(!statusOptional.isPresent())
      {
          throw new ResourseNotFoundException("Status Not Found");
      }
      return new ResponseEntity(statusOptional.get(),HttpStatus.OK);
    }
}
