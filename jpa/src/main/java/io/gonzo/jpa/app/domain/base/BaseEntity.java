package io.gonzo.jpa.app.domain.base;

import io.gonzo.jpa.app.utils.SecurityUtils;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.Instant;

@Getter
@MappedSuperclass
public abstract class BaseEntity {

    @CreatedBy
    @Column(name = "create_by", nullable = false)
    private String createBy;

    @LastModifiedBy
    @Column(name = "update_by", nullable = false)
    private String updateBy;

    @CreatedDate
    @CreationTimestamp
    @Column(name = "create_date", nullable = false)
    private Instant createDate;

    @UpdateTimestamp
    @LastModifiedDate
    @Column(name = "update_date")
    private Instant updateDate;

    @PrePersist
    public void prePersist() {
        this.createBy = SecurityUtils.getByCurrentLoginName().orElse("system");
        this.updateBy = SecurityUtils.getByCurrentLoginName().orElse("system");
    }

    @PreUpdate
    public void preUpdate() {
        this.updateBy = SecurityUtils.getByCurrentLoginName().orElse("system");
    }

}
