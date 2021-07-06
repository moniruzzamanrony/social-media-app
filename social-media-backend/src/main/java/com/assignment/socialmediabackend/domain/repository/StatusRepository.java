package com.assignment.socialmediabackend.domain.repository;


import com.assignment.socialmediabackend.domain.model.Role;
import com.assignment.socialmediabackend.domain.model.Status;
import com.assignment.socialmediabackend.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StatusRepository extends JpaRepository<Status, String> {

    @Query("SELECT u FROM Status u WHERE u.createdBy = :username")
    List<Status> findAllUserName(String username);
}
