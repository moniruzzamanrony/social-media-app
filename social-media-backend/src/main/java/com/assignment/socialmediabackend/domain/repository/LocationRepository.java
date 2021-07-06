package com.assignment.socialmediabackend.domain.repository;


import com.assignment.socialmediabackend.domain.model.Locations;
import com.assignment.socialmediabackend.domain.model.Role;
import com.assignment.socialmediabackend.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Locations, Integer> {
}
