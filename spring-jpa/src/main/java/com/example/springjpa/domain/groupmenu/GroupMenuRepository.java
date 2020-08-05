package com.example.springjpa.domain.groupmenu;

import com.example.springjpa.domain.group.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface GroupMenuRepository extends JpaRepository<GroupMenu , Long> {

    @Transactional
    List<GroupMenu> findByGroups(Group group);

}
