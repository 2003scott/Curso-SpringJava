package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // Concepto 1 - como obtener beans de spring
        // Opcion 1 crear un objeto de forma normal
        // Calculadora service = new Calculadora();

        // Opcion 2 Recibir un obj de Spring
        Calculadora calculadora = (Calculadora) context.getBean("calculadora");
        String texto = calculadora.holaMundo();
        System.out.println(texto);
        // se puede volver a obtener
        // OJO:se recupera el mismo objeto
        Calculadora calculadora2 = (Calculadora) context.getBean("calculadora");
        texto = calculadora.holaMundo();
        System.out.println(texto);

        // Concepto 2 - cargar un bean de otro bean
         GestorFactura gestor =(GestorFactura) context.getBean("gestorFacturas");
        System.out.println(gestor.calculadora.holaMundo());

        // Concepto 3 - scope o alcance
        // los beans por degento son singleton se crea el objeto y se reutiza para toda la aplicacion
        // podemos cambiarla a prototype si queremos que se cree un nuevo objeto cada vez
        // verificarlo viendo como se ejecuta varias veces un constructor
    }
}
