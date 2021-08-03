package io.gonzo.jpa.app.domain.app;

import io.gonzo.jpa.app.domain.app.base.AppBaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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

//    @Co
//    private List<AppUser> appUsers;
}
