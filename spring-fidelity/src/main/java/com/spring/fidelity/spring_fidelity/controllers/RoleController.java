package com.spring.fidelity.spring_fidelity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoleController {
    @GetMapping("/Ruolo")
    public String Ruolo(){
        return "Prova";
    }
}
