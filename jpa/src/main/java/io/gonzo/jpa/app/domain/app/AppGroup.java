package io.gonzo.jpa.app.domain.app;

import io.gonzo.jpa.app.domain.app.base.AppBaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Table(name = "app_group")
@Entity
@NoArgsConstructor
public class AppGroup extends AppBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "group_title", nullable = false)
    private String title;

    @Column(name = "use_yn")
    private Boolean useYn;

    @ManyToMany
    private Set<AppUser> appUsers = new HashSet<>();

    @OneToMany
    private Set<AppAuth> appAuths = new HashSet<>();

}
