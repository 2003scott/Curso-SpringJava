package com.example;

import org.springframework.stereotype.Component;

@Component
public class Calculadora {

    public String holaMundo(){
        return "hola Mundo";
    }

    public Calculadora(){
        System.out.println("Ejecutando constructor calculadoraService");
    }
}
