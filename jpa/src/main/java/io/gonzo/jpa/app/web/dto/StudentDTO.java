package io.gonzo.jpa.app.web.dto;

import io.gonzo.jpa.app.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class StudentDTO {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Store {

        private String firstName;

        private String lastName;

        public Student toEntity() {
            return Student.builder()
                    .firstName(this.firstName)
                    .lastName(this.lastName)
                    .build();
        }

    }

}