package com.example.jpa.api.service.dto;

import com.example.jpa.data.domain.Job;
import com.example.jpa.data.domain.User;
import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
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

        private List<Long> userIdList = new ArrayList<>();

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
            return Result.builder()
                    .title(job.getTitle())
                    .content(job.getContent())
                    .userIds(job.getUsers().stream().map(User::getId).collect(Collectors.toSet()))
                    .createBy(job.getCreateBy())
                    .updateBy(job.getUpdateBy())
                    .createDate(job.getCreateDate())
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

}
