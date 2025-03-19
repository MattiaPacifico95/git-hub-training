package com.spring.fidelity.spring_fidelity.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CatalogoController {
    @GetMapping("/Catalogo")
    public String catalogo(){
        return "Prova";
    }
}

