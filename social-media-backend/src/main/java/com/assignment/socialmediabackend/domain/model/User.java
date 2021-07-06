package com.assignment.socialmediabackend.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username"
        })
})
public class User extends BaseEntity {

    @Id
    private String id;


    @Size(min = 3,max = 10)
    @Column(name = "username", nullable = false)
    private String username;

    @Size(min = 4,max = 50)
    @Column(name = "name", nullable = false)
    private String name;


    @Size(min = 10,max = 50)
    @Column(name = "email", nullable = false)
    private String email;

    @Size(min = 11,max = 15)
    @Column(name = "phone_no", nullable = false)
    private String phoneNo;


    @Size(min = 0,max = 255)
    @Column(name = "address", nullable = true)
    private String address;

    @Size(min = 6,max = 50)
    @Column(name = "password", nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();


}
