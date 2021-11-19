package io.gonzo.jpa.app.domain;

import io.gonzo.jpa.app.domain.base.BaseEntity;
import io.gonzo.jpa.app.domain.base.Name;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_student")
public class Student extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Embedded
    private Name name;

    @Builder
    public Student(String firstName, String lastName) {
        this.name = Name.builder()
                .firstName(firstName)
                .lastName(lastName)
                .build();
    }

}
