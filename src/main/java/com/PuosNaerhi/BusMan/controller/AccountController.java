package com.PuosNaerhi.BusMan.controller;

import com.PuosNaerhi.BusMan.domain.service.UserService;
import com.PuosNaerhi.BusMan.domain.service.impl.BusPlaceFacade;
import com.PuosNaerhi.BusMan.web.UserForm;
import com.PuosNaerhi.BusMan.web.UserRegisterForm;
import com.PuosNaerhi.BusMan.web.WwwUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

/**
 * Created by Perttu Vanharanta on 24.10.2016.
 */

@Controller
public class AccountController {

    @Autowired
    UserService userService;

    @Autowired
    BusPlaceFacade busPlaceFacade;

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

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String ProfileUserGet(Principal principal, Model model)
    {
        String name = null;
        if(principal != null){
            name = principal.getName();
            model.addAttribute("UserProfile", userService.getUser(name));
            model.addAttribute("ReservedPlaces", busPlaceFacade.usersReserverPlaces(userService.getUserEntity(name)));
            return "/profile";
        } else {
            return "redirect:/home";
        }
    }
    @RequestMapping(value = "/userlist", method = RequestMethod.GET)
    public String UserListGet(Model model)
    {
        model.addAttribute("Users", userService.getUserList());
        return "/userlist";
    }

    @RequestMapping(value = "/userupdate/{id}", method = RequestMethod.GET)
    public String updateUserGet(@PathVariable("id") Integer id, Model model){
        WwwUser wwwUser = userService.getUserById(id);
        if(wwwUser != null) {
            model.addAttribute("UserObject", wwwUser);
            model.addAttribute("UserId", id);
            return "/userupdate";
        }else{
            return "redirect:/home";
        }
    }


    @RequestMapping(value = "/userupdate/{id}", method = RequestMethod.POST)
    public String updateUserPost(@PathVariable("id") Integer id, @ModelAttribute("UserObject")UserForm userForm, Model model) {
        userService.updateUser(id, userForm.getUsername(), userForm.getEmail());
        return "redirect:/home";
    }


    @RequestMapping(value = "/userdelete/{id}", method = RequestMethod.GET)
    public String deleteUserGet(@PathVariable("id") Integer id, Model model){
        userService.deleteUser(id);
        return "redirect:/home";
    }

    @RequestMapping(value = "/userprofile/{id}", method = RequestMethod.GET)
    public String viewUserGet(@PathVariable("id") Integer id, Model model) {
        WwwUser wwwUser = userService.getUserById(id);
        if(wwwUser != null){
            model.addAttribute("UserProfile", wwwUser);
            model.addAttribute("ReservedPlaces", busPlaceFacade.usersReserverPlaces(userService.getUserEntity(wwwUser.getUsername())));
            return "/profile";
        } else {
            return "redirect:/home";
        }


    }

}
