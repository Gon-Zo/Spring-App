package io.gonzo.jpa.app.web;

import io.gonzo.jpa.app.config.security.RoleType;
import io.gonzo.jpa.app.utils.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewResource {

    @GetMapping("/home")
    public String goByHom() {

        boolean isSystem = SecurityUtils.isAuthenticationTypeAble(RoleType.SYSTEM);

        boolean isAdmin = SecurityUtils.isAuthenticationTypeAble(RoleType.ADMIN);

        boolean isUser = SecurityUtils.isAuthenticationTypeAble(RoleType.USER);

        if (isSystem) {
            return "system";
        }

        if (isAdmin) {
            return "admin";
        }

        if (isUser) {
            return "user";
        }

        return "error";
    }

}
