package com.epam.controller;

import com.epam.controller.util.UserValidator;
import com.epam.model.User;
import com.epam.model.lcp.UserProfile;
import com.epam.model.lcp.UserStatus;
import com.epam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * Created by Sahak_Babayan on 3/30/2016.
 */
@Controller
public class RegistrationController {

    private UserService userService;

    private MessageSource messageSource;

//    private UserValidator validator;

    @Autowired
    RegistrationController(UserService userService, MessageSource messageSource, UserValidator validator) {
        this.userService = userService;
        this.messageSource = messageSource;
//        this.validator = validator;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(User user, Model model) {
    	
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();

    	if (!(auth instanceof AnonymousAuthenticationToken)) {

    	    /* The user is logged in :) */
    	    return "redirect:/home";
    	}
    	
    	model.addAttribute("classActiveRegister", "active");
        return "pages/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestParam("confirmPassword") String confirmPassword,
                           @Valid User user,
                           BindingResult result, 
                           Model model) {
    	
    	model.addAttribute("classActiveRegister", "active");

//        validator.validate(user, result);

        if(result.hasErrors()) {
            return "pages/register";
        }

        // validating password
        if(StringUtils.isEmpty(user.getPassword())) {
            String message = messageSource.getMessage("err.field.password.required", null, LocaleContextHolder.getLocale());
            result.addError(new FieldError("user", "password", message));
            return "pages/register";
        }

        if(!user.getPassword().equals(confirmPassword)) {
            String message = messageSource.getMessage("err.field.mismatched.confirm.password", null, LocaleContextHolder.getLocale());
            result.addError(new FieldError("user", "password", message));
            return "pages/register";
        }

        // checking whether the email address is already used
        boolean isEmailExist = userService.isEmailExist(user.getEmail());
        if(isEmailExist) {
            String message = messageSource.getMessage("err.field.email.exist", null, LocaleContextHolder.getLocale());
            result.addError(new FieldError("user", "email", message));
            return "pages/register";
        }

        user.setStatus(UserStatus.ACTIVE);
        user.setProfile(UserProfile.USER);

        // storing user's data
        userService.add(user);

        // going to login page
        return "redirect:login";
    }

}
