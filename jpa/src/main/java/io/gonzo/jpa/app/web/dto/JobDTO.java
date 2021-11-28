package io.gonzo.jpa.app.web.dto;

import com.sun.istack.NotNull;
import io.gonzo.jpa.app.domain.Job;
import io.gonzo.jpa.app.domain.User;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class JobDTO {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Store {

        @NotNull
        private String title;

        @NotNull
        private String content;

        private List<Long> userIdList;

        public Job toEntity(Set<User> users) {
            return Job.builder()
                    .title(this.title)
                    .content(this.content)
                    .users(users)
                    .build();
        }

    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserIds {

        private Long id;

        private String title;

        private String content;

        private Set<Long> userIds;

        public UserIds convertBy(Job job) {
            this.id = job.getId();
            this.title = job.getTitle();
            this.content = job.getContent();
            this.userIds = job.getUsers().stream().map(User::getId).collect(Collectors.toSet());
            return this;
        }

    }

    public interface OnlyTitle {
        String getTitle();
    }

    public interface IUserIds {
        Long getId();

        String getTitle();

        String getContent();

        @Value("#{target.title} = #{target.content}")
        String getValue();

        @Value("#{target.users}")
        Set<Ids> getUserIds();

        interface Ids {
            Long getId();
        }

    }

}
