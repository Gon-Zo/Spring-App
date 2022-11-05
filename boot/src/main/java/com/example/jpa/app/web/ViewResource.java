package com.example.jpa.app.web;

import com.example.jpa.app.config.security.RoleType;
import com.example.jpa.app.utils.SecurityUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ViewResource {

    @GetMapping("/home")
    public String goByHom(Model model) {

        boolean isSystem = SecurityUtil.isAuthenticationTypeAble(RoleType.SYSTEM);

        boolean isAdmin = SecurityUtil.isAuthenticationTypeAble(RoleType.ADMIN);

        boolean isUser = SecurityUtil.isAuthenticationTypeAble(RoleType.USER);

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

        String loginUserName = SecurityUtil.getByCurrentLoginName().orElseThrow(() -> new NullPointerException());

        useMap.put("name", loginUserName);

        model.addAttribute("user", useMap);

        return;
    }
}
