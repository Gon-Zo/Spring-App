package io.gonzo.jpa.app.web.dto;

import com.sun.istack.NotNull;
import io.gonzo.jpa.app.domain.Job;
import io.gonzo.jpa.app.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    public interface OnlyTitle {
        String getTitle();
    }

}
