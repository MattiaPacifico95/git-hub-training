package com.spring.fidelity.spring_fidelity.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class TesseraController {
    @GetMapping("/Tessera")
    public String Tessera(){
        return "Prova";
    }
}
