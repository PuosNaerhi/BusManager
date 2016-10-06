package com.PuosNaerhi.BusMan.controller;

import com.PuosNaerhi.BusMan.domain.entity.BusEntity;
import com.PuosNaerhi.BusMan.domain.service.impl.BusPlaceFacade;
import com.PuosNaerhi.BusMan.web.BusForm;
import com.PuosNaerhi.BusMan.web.PlaceForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Perttu Vanharanta on 6.10.2016.
 */

@Controller
public class PlaceController {

    @Autowired
    BusPlaceFacade busPlaceFacade;


    @RequestMapping(value = "/bus/{id}", method = RequestMethod.GET)
    public String updateBusPlaceGet(@PathVariable("id") Integer id, Model model){
        BusEntity busEntity = busPlaceFacade.readBus(id);
        if(busEntity != null) {
            model.addAttribute("BusObject", busPlaceFacade.readBus(id));
            model.addAttribute("PlaceObjects", busPlaceFacade.listPlace(busEntity));
            return "/bus";
        }else{
            return "redirect:/home";
        }
    }


    @RequestMapping(value = "/bus/{id}", method = RequestMethod.POST)
    public String updateBusPlacePost(@PathVariable("id") Integer id, @ModelAttribute("placeNumber") PlaceForm placeForm, Model model){
        busPlaceFacade.updatePlaceReserve(id, placeForm.getPlaceId(), placeForm.getReserver());
        return "redirect:/home";
    }

}
