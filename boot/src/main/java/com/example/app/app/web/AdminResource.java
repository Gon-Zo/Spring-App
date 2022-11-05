package com.example.app.app.web;

//import org.springframework.security.access.prepost.PreAuthorize;

import com.example.app.app.config.security.RoleType;
import com.example.app.app.utils.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminResource {

    //    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("")
    public String getByAdmin() {
        boolean isAdmin = SecurityUtils.isAuthenticationTypeAble(RoleType.ADMIN);
        log.info("ADMIN_PAGE|isAdmin={}", isAdmin);
        return "SUCCESS";
    }

}
