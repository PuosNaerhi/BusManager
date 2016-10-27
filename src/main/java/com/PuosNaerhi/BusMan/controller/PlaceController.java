package com.PuosNaerhi.BusMan.controller;

import com.PuosNaerhi.BusMan.domain.entity.BusEntity;
import com.PuosNaerhi.BusMan.domain.entity.UserEntity;
import com.PuosNaerhi.BusMan.domain.service.UserService;
import com.PuosNaerhi.BusMan.domain.service.impl.BusPlaceFacade;
import com.PuosNaerhi.BusMan.web.BusForm;
import com.PuosNaerhi.BusMan.web.PlaceForm;
import com.PuosNaerhi.BusMan.web.WwwUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

/**
 * Created by Perttu Vanharanta on 6.10.2016.
 */

@Controller
public class PlaceController {

    @Autowired
    UserService userService;

    @Autowired
    BusPlaceFacade busPlaceFacade;


    @RequestMapping(value = "/bus/{id}", method = RequestMethod.GET)
    public String updateBusPlaceGet(@PathVariable("id") Integer id, Principal principal, Model model){
        String name = null;
        BusEntity busEntity = busPlaceFacade.readBus(id);
        if(busEntity != null) {
            model.addAttribute("BusObject", busPlaceFacade.readBus(id));
            model.addAttribute("PlaceObjects", busPlaceFacade.listPlace(busEntity));

            if(principal != null){
                name = principal.getName();
            }
            model.addAttribute("Reserver", name);
            return "/bus";
        }else{
            return "redirect:/home";
        }
    }


    @RequestMapping(value = "/bus/{id}", method = RequestMethod.POST)
    public String updateBusPlacePost(@PathVariable("id") Integer id, @ModelAttribute("placeNumber") PlaceForm placeForm, Model model){

        UserEntity userEntity = userService.getUserEntity(placeForm.getReserver());
        busPlaceFacade.updatePlaceReserve(id, placeForm.getPlaceId(), userEntity);
        return "redirect:/home";
    }

    @RequestMapping(value = "/unreserve/{id}", method = RequestMethod.GET)
    public String unreservePlace(@PathVariable("id") Integer id, Model model){
        busPlaceFacade.updateCancelPlaceReserve(id);
        return "redirect:/profile";
    }

}
