package com.PuosNaerhi.BusMan.controller;

import com.PuosNaerhi.BusMan.domain.service.UserService;
import com.PuosNaerhi.BusMan.web.UserRegisterForm;
import com.PuosNaerhi.BusMan.web.WwwUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Perttu Vanharanta on 24.10.2016.
 */

@Controller
public class AccountController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerUserGet() {
        return "/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUserPost(@ModelAttribute("user") UserRegisterForm user, Model model) {
        String role = userService.isFirstUser();
        userService.createUser(new WwwUser(user.getUsername(), user.getPassword(), user.getEmail(), role));
        return "redirect:/home";
    }

}
