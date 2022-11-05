package com.example.jpa.domain;

import com.example.jpa.domain.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Getter
@Entity
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "jobs")
public class Job extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @ManyToMany(targetEntity = User.class)
    @JoinTable(name = "jobs_users", joinColumns = @JoinColumn(name = "job_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    @JsonIgnoreProperties({"groups", "gender"})
    private Set<User> users = new HashSet<>();

    @Builder
    private Job(String title, String content, Set<User> users) {
        this.title = title;
        this.content = content;
        this.users = users;
    }

    @Transient
    public void update(String title, String content, Set<User> userSet) {
        this.title = title;
        this.content = content;
        this.users = userSet;
    }
}
