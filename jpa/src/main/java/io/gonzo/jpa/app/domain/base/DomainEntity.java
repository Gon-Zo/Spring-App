package io.gonzo.jpa.app.domain.base;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.Instant;

@Getter
@MappedSuperclass
public class DomainEntity extends BaseEntity {

    @CreationTimestamp
    @Column(name = "CREATE_DATE" , nullable = false , updatable = false)
    protected Instant createDate;

    @UpdateTimestamp
    @Column(name = "UPDATE_DATE" , nullable = false)
    protected Instant updateDate;

}
