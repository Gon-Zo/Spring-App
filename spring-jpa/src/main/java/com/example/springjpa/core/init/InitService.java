package com.example.springjpa.core.init;

import com.example.springjpa.domain.group.Group;
import com.example.springjpa.domain.group.GroupRepository;
import com.example.springjpa.domain.groupmenu.GroupMenu;
import com.example.springjpa.domain.groupmenu.GroupMenuRepository;
import com.example.springjpa.domain.menu.Menu;
import com.example.springjpa.domain.menu.MenuRepository;
import com.example.springjpa.domain.user.User;
import com.example.springjpa.domain.user.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class InitService {

    private final GroupRepository groupRepository;

    private final GroupMenuRepository groupMenuRepository;

    private final MenuRepository menuRepository;

    private final UserRepository userRepository;


    public InitService(GroupRepository groupRepository,
                       GroupMenuRepository groupMenuRepository,
                       MenuRepository menuRepository,
                       UserRepository userRepository) {
        this.groupRepository = groupRepository;
        this.groupMenuRepository = groupMenuRepository;
        this.menuRepository = menuRepository;
        this.userRepository = userRepository;
    }

    public void createByStartData() {

        List<Menu> menuList = new ArrayList<>();

        Group adminGroup = null;

        long groupCnt = groupRepository.count();

        if (groupCnt == 0) {

            adminGroup = groupRepository
                    .saveAndFlush(Group.builder()
                            .title("ADMIN")
                            .build());

        }

        long menuCnt = menuRepository.count();

        if (menuCnt == 0) {

            List<String> urls = Arrays.asList("/api/app/post", "/api/app/user");

            for (String url : urls) {

                Menu menu = menuRepository.saveAndFlush(Menu.builder()
                        .url(url)
                        .build());

                menuList.add(menu);
            }

        }

        long groupMenuCnt = groupMenuRepository.count();

        if (groupMenuCnt == 0) {

            for (Menu menu : menuList) {
                groupMenuRepository.save(GroupMenu.builder()
                        .groups(adminGroup)
                        .menus(menu)
                        .build());


            }
        }

        long userCnt = userRepository.count();

        if(userCnt == 0){

            userRepository.save(
                    User.builder()
                            .email("admin")
                            .password(new BCryptPasswordEncoder().encode("1111"))
                            .name("admin")
                            .groups(Arrays.asList(adminGroup))
                            .build()
            );

        }

    }

}
