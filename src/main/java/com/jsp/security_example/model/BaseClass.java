package com.jsp.security_example.model;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public class BaseClass {


    @CreationTimestamp
    LocalDateTime cratedAt;
   @UpdateTimestamp
    LocalDateTime updatedAt;


    @CreatedBy
    String createdBy;

    @LastModifiedBy
    String updatedBy;
}
