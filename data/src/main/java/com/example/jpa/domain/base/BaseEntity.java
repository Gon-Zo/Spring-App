package com.example.jpa.domain.base;

import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.Instant;

@Getter
@MappedSuperclass
@EntityListeners(value = {AuditingEntityListener.class})
public abstract class BaseEntity {

    @CreatedBy
    @Column(name = "create_by", nullable = false)
    private String createBy;

    @LastModifiedBy
    @Column(name = "update_by", nullable = false)
    private String updateBy;

    @CreatedDate
    @Column(name = "create_date", nullable = false)
    private Instant createDate;

    @LastModifiedDate
    @Column(name = "update_date")
    private Instant updateDate;

}
