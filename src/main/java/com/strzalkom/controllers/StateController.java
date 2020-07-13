package com.strzalkom.controllers;

import com.strzalkom.domain.Car;
import com.strzalkom.domain.State;
import com.strzalkom.services.CarService;
import com.strzalkom.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StateController {

    @Autowired
   CarService carService;

    @Autowired
    StateService stateService;



    @RequestMapping("/assignState")
    public String assignState(@RequestParam("carId") Integer id, Model model) {
        Car car = carService.getCar(id);
        List<State> notStartedStates = stateService.getAllNotStartedStates();
        model.addAttribute("car", car);
        model.addAttribute("notStartedStates", notStartedStates);
        return "assignState";
    }

    @RequestMapping(value = "/assignState", method = RequestMethod.POST)
    public String assignState(Car car, BindingResult result) {
        System.out.println(result);
        carService.updateCar(car);

        return "redirect:/cars";
    }



}
