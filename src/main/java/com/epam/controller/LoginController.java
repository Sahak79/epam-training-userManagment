package com.epam.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.model.User;
import com.epam.model.lcp.UserProfile;

/**
 * Created by Sahak_Babayan on 3/30/2016.
 */
@Controller
public class LoginController {
	
	
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
    	
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();

    	if (!(auth instanceof AnonymousAuthenticationToken)) {

    	    /* The user is logged in :) */
    	    return "redirect:/home";
    	}
    	
    	model.addAttribute("classActiveLogin", "active");
        return "pages/login";
    }

    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    @RequestMapping("/home")
    public String home(@AuthenticationPrincipal User user) {
        if (user.getProfile() == UserProfile.ADMIN) {
            return "redirect:admin/home";
        }
        return "redirect:user/home";
    }
}
