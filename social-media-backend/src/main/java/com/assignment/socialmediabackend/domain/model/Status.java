package com.assignment.socialmediabackend.domain.model;

import com.assignment.socialmediabackend.enums.PostPrivecy;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "status")
public class Status extends BaseEntity{

    @Id
    private String id;

    @Size(max = 10000)
    @Column(name = "body", nullable = false)
    private String statusBody;

    @Size(max = 50)
    @Column(name = "post_privecy", nullable = false)
    private PostPrivecy postPrivecy;

    @Size(max = 50)
    @Column(name = "location", nullable = false)
    private String location;


}
