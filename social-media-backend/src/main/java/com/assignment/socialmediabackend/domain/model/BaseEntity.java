package com.assignment.socialmediabackend.domain.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.Instant;
import java.time.LocalDateTime;

@Data
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class BaseEntity {

    @CreatedBy
    @Column(length = 36)
    private String createdBy;

    @LastModifiedBy
    @Column(length = 36)
    private String updatedBy;

    @UpdateTimestamp
    private LocalDateTime editTimestamp;

    @CreationTimestamp
    private LocalDateTime creationTimestamp;
}
