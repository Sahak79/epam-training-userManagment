package com.epam.controller.user;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.model.User;

@Controller
@PreAuthorize("hasRole('ROLE_USER')")
public class UserController {

    @RequestMapping("/user/home")
    public String homeUser(@AuthenticationPrincipal User user) {
        return "pages/user/home";
    }
}
