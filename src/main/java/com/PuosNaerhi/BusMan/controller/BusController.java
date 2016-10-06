package com.PuosNaerhi.BusMan.controller;

import com.PuosNaerhi.BusMan.domain.entity.BusEntity;
import com.PuosNaerhi.BusMan.domain.service.BusService;
import com.PuosNaerhi.BusMan.domain.service.impl.BusPlaceFacade;
import com.PuosNaerhi.BusMan.web.BusForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Perttu Vanharanta on 5.10.2016.
 */

@Controller
public class BusController {

    @Autowired
    BusPlaceFacade busPlaceFacade;

    @RequestMapping(value = {"", "/", "/home"})
    public String home(Model model) {

        model.addAttribute("BusObjects",busPlaceFacade.listBus());
        return "/home";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createBusGet(Model model){

        return "/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createBusPost(@ModelAttribute("BusObject")BusForm busForm, Model model){
        busPlaceFacade.createBusPlace(busForm.getStartLocation(), busForm.getEndLocation(), busForm.getBusSize());
        return "redirect:/home";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateBusGet(@PathVariable("id") Integer id, Model model){
        BusEntity busEntity = busPlaceFacade.readBus(id);
        if(busEntity != null) {
            model.addAttribute("BusObject", busPlaceFacade.readBus(id));
            return "/update";
        }else{
            return "redirect:/home";
        }
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String updateBusPost(@PathVariable("id") Integer id, @ModelAttribute("BusObject")BusForm busForm, Model model) {
        busPlaceFacade.updateBusPlace(id, busForm.getStartLocation(), busForm.getEndLocation(), busForm.getBusSize());
        return "redirect:/home";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBusGet(@PathVariable("id") Integer id, Model model){
        busPlaceFacade.deleteBusPlace(id);
        return "redirect:/home";
    }


}
