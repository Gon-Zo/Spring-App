package com.example.jpa.api.service.dto;

import com.example.jpa.domain.Job;
import com.example.jpa.domain.User;
import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import java.time.Instant;
import java.util.*;
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

        private List<Long> userIdList = new ArrayList<>();

        public Job toEntity(Collection<User> users) {
            return Job.builder()
                    .title(this.title)
                    .content(this.content)
                    .users((Set<User>) users)
                    .build();
        }

    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Result {

        private Long id;

        private String title;

        private String content;

        private Set<Long> userIds = new HashSet<>();

        private String createBy;

        private String updateBy;

        private Instant createDate;

        private Instant updateDate;

        public static Result convertBy(Job job) {

            Set<Long> idSet = job.getUsers().stream().map(User::getId).collect(Collectors.toSet());

            return Result.builder()
                    .title(job.getTitle())
                    .content(job.getContent())
                    .userIds(idSet)
                    .createBy(job.getCreatedBy())
                    .updateBy(job.getUpdatedBy())
                    .createDate(job.getCreatedDate())
                    .updateDate(job.getUpdateDate())
                    .build();
        }

    }

    public interface IOnlyTitle {
        String getTitle();

        @Value("#{target.title} = #{target.content}")
        String getValue();
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

    public interface Info {
        Long getId();

        String getTitle();

        String getContent();

    }

}
