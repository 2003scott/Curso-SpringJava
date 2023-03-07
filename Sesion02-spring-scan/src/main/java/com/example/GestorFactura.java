package com.example;

import org.springframework.stereotype.Component;

@Component
public class GestorFactura {

    // 1. atributos
    Calculadora calculadora;

    // 2. Constructores
    public GestorFactura(Calculadora calculadora ){
        System.out.println("Ejecutando constructor GestorFactura");
        this.calculadora= calculadora;
    }

    // 3. Metodos
}
