package io.gonzo.jpa.app.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.gonzo.jpa.app.domain.base.AppBaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.BooleanUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Table(name = "app_group")
@Entity
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Group extends AppBaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "group_title", nullable = false)
    private String title;

    @Column(name = "use_yn" , nullable = false)
    private Boolean useYn;

    @ManyToMany(mappedBy = "groups")
    private Set<User> users = new HashSet<>();

//    @ManyToMany
//    private Set<AppAuth> appAuths = new HashSet<>();

    @PrePersist
    public void onPrePersist(){
        if(BooleanUtils.isNotTrue(this.useYn)){
            this.useYn = Boolean.FALSE;
        }
    }
}
