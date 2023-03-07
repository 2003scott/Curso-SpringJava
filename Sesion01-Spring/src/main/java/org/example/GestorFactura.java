package org.example;

public class GestorFactura {

    // 1. atributos
    Calculadora calculadora;
    String nombre;

    // 2. Constructores
    public GestorFactura(Calculadora calculadora, String nombre){
        System.out.println("Ejecutando constructor GestorFactura");
        this.calculadora= calculadora;
        this.nombre= nombre;
    }

    // 3. Metodos
}
