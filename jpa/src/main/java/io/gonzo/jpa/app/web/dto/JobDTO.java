package io.gonzo.jpa.app.web.dto;

import com.sun.istack.NotNull;
import io.gonzo.jpa.app.domain.Job;
import io.gonzo.jpa.app.domain.User;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Set;

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
