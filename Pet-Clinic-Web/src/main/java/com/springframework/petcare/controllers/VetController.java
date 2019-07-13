package com.springframework.petcare.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

    @RequestMapping({"/listOfVets", "vets/index", "vets/index.html"})
    public String listVets() {
        return "vets/vetsIndex";
    }
}
