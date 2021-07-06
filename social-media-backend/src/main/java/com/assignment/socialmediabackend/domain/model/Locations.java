package com.assignment.socialmediabackend.domain.model;

import com.assignment.socialmediabackend.enums.RoleName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Table(name = "locations")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Locations {
    @Id
    private int id;


    @Column(length = 60)
    private String location;


}
