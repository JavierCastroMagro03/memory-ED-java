/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaed_memory_javiercastromagro;

/**
 * @author Javier Castro Magro
 */

public class Carta {
    //ATRIBUTOS 
    private String nombre;  //Guardará el símbolo o nombre de la carta (ej. "A", "7", "Z"...)
    private boolean pareja;  //Para distinguir  dos cartas de la misma pareja (una tendrá true y la otra false)
    private boolean  revelada;  //Será  true cuando se  haya encontrado la  pareja (y saldrá  mostrada en el tablero)
    
    //CONSTRUCTOR
    public Carta(String nombre, boolean pareja)
    {
        this.nombre = nombre;
        this.pareja = pareja;   //Para diferenciar las dos cartas con mismo nombre
        this.revelada = false;  //Inicializamos la carta a no revelada
    }
    
    //GETTERS
    //getNombre (devolverá el nombre de la carta)
    public String getNombre()
    {
        return nombre;
    }
    //isPareja (devolverá true o false dependiendo que cuál de  las dos parejas sea)
    public boolean isPareja()
    {
        return pareja;
    }
    //isRevelada (devuelve si la carta está revelada o no)
    public boolean isRevelada()
    {
        return revelada;
    }
    
    //SETTERS
    //setRevelada (para marcar si está revelada o no)
    public void setRevelada(boolean revelada)
    {
        this.revelada = revelada;
    }
    
    //MÉTODOS
    //Método equals para comprobar si dos cartas son la misma(comparando nombre y pareja)
    @Override
    public boolean equals(Object obj)
    {
        if(this == obj) return true; //Si son el mismo objeto devolverá true
        if(!(obj instanceof Carta)) return false; //En caso de recibir algo que no sea una carta
        Carta otra = (Carta) obj; //Convertimos el obj recibido a carta
        return this.nombre.equals(otra.nombre) && this.pareja == otra.pareja; //Comparamos si tienen el mismo nombre y el mismo valor de pareja
    }
    
    //Representar la carta como texto
    //[ ] si no está revelada
    //p.e [A] si está revelada
    @Override
    public String toString() 
    {
        return "[" + (revelada ? nombre : " ") + "]";
    }
}//Fin Clase Carta
