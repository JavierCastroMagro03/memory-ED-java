/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaed_memory_javiercastromagro;

/**
 * @author Javier Castro Magro
 */

public class Jugador {
    //ATRIBUTOS
    private String nombre;  //Para guardar el nombre del jugador
    private ListG<Carta> cartasGanadas;  //Lista en la que se añaden las cartas que ha emparejado el jugador
    
    //CONSTRUCTOR
    public Jugador(String nombre)
    {
        this.nombre = nombre;
        this.cartasGanadas = new ListArrayG<>(40); //40 porque son el número máximo de cartas que puede haber en el tablero
    }
    
    //GETTERS
    //Getter del nombre
    public String getNombre()
    {
        return nombre;
    }
    
    //MÉTODOS
    //Añadir una carta ganada (se lanza una vez por cada carta de la pareja)
    public void añadirCartaGanada(Carta carta)
    {
        cartasGanadas.add(carta);
    }
    
    //Obtener lista de cartas ganadas
    public ListG<Carta> getCartasGanadas()
    {
        return cartasGanadas;
    }
    
    //Mostrar cartas ganadas por consola
    public void mostrarCartasGanadas()
    {
        System.out.println("Cartas ganadas por " + nombre + ": ");
        for (int i = 0; i < cartasGanadas.size(); i++) 
        {
            System.out.print(cartasGanadas.get(i).getNombre() + " ");
        }
        System.out.println();
    }
}//Fin Clase Jugador
