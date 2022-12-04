package com.example.jpa.api.service.dto;

import com.example.jpa.constant.Gender;
import com.example.jpa.constant.UserStatus;
import com.example.jpa.domain.base.BirthDate;
import com.example.jpa.domain.base.Name;
import com.example.jpa.domain.user.User;
import com.example.jpa.domain.user.UserFail;
import com.example.jpa.domain.user.UserMeta;
import com.example.jpa.domain.user.UserPassword;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class SignUpDTO {

    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {

        @NotNull
        private String email;

        @NotNull
        private UserStatus status;

        @NotNull
        private String password;

        @NotNull
        private String firstName;

        @NotNull
        private String lastName;

        @NotNull
        private Gender gender;

        @NotNull
        private String birthDate;

        public User toUser(UserMeta userMeta, UserPassword userPassword, UserFail userFail) {
            return User.builder().email(this.email).status(this.status).userMeta(userMeta).userPassword(userPassword).userFail(userFail).build();
        }

        public UserMeta toMeta() {

            final Name name = new Name(this.firstName, this.lastName);

            final BirthDate birthDate = BirthDate.of(this.birthDate);

            return UserMeta.builder().name(name).gender(this.gender).birthDate(birthDate).build();
        }

        public UserPassword toPassword(String encodePassword) {
            return new UserPassword(encodePassword);
        }

        public UserFail toFail() {
            return new UserFail(BigDecimal.ZERO);
        }
    }

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response {

        private Long id;

        private String email;

        private LocalDateTime createdAt;

        public Response(User user) {
            this.id = user.getId();
            this.email = user.getEmail();
            this.createdAt = user.getCreatedAt();
        }
    }
}
