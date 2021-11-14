package io.gonzo.jpa.app.web;

import io.gonzo.jpa.app.config.security.RoleType;
import io.gonzo.jpa.app.utils.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ViewResource {

    @GetMapping("/home")
    public String goByHom(Model model) {

        boolean isSystem = SecurityUtils.isAuthenticationTypeAble(RoleType.SYSTEM);

        boolean isAdmin = SecurityUtils.isAuthenticationTypeAble(RoleType.ADMIN);

        boolean isUser = SecurityUtils.isAuthenticationTypeAble(RoleType.USER);

        if (isSystem) {
            getByUserModel(model);
            return "system";
        }

        if (isAdmin) {
            getByUserModel(model);
            return "admin";
        }

        if (isUser) {
            getByUserModel(model);
            return "user";
        }

        return "error";
    }

    private void getByUserModel(Model model) {

        Map<String, Object> useMap = new HashMap<>();

        String loginUserName = SecurityUtils.getByCurrentLoginName().orElseThrow(() -> new NullPointerException());

        useMap.put("name", loginUserName);

        model.addAttribute("user", useMap);

        return;
    }
}
