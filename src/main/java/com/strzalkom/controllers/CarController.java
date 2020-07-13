package com.strzalkom.controllers;

import com.strzalkom.domain.Car;
import com.strzalkom.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
import java.util.List;

@Controller
public class CarController {

    @Autowired
    CarService service;

    @RequestMapping("/cars")
    public String getCars(Model model) {
        List<Car> allCars = service.getAllCars();
        model.addAttribute("cars", allCars);

        return "cars";
    }

    @RequestMapping("/car")
    public String getCar(@RequestParam("id") Integer id, Model model) {
        Car car = service.getCar(id);
        model.addAttribute("car", car);

        return "car";
    }

    @RequestMapping("/newcar")
    public String createCar(Model model) {
        model.addAttribute("car", new Car());

        return "carform";
    }

    @RequestMapping(value = "/cars", method = RequestMethod.POST)
    public String saveCar(@Valid Car car, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println("There were errors");
            bindingResult.getAllErrors().forEach(error -> {
                        System.out.println(error.getObjectName() + " " + error.getDefaultMessage());
                    }
            );
            return "carform";
        } else {
            service.saveCar(car);
            return "redirect:/cars";
        }

    }

    @RequestMapping(value = "/car/delete/{id}")
    public String deleteCar(@PathVariable("id") Integer id) {
        service.deleteCar(id);
        return "redirect:/cars";
    }
}
