/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaed_memory_javiercastromagro;
import java.util.Random;

/**
 * @author Javier Castro Magro
 */
public class Baraja {
    private SetArrayG<Carta> cartas; //Conjunto de cartas no repetidas
    
    //CONSTRUCTOR (crea el conjunto vacío)
    public Baraja()
    {
        cartas = new SetArrayG<>();
    }
    
    //MÉTODOS
    //Inicializar la baraja con todas las parejas
    public void inicializarBaraja()
    {
        //Letras
        for (char c = 'A'; c <= 'Z'; c++) 
        {
            //Dos cartas por letra. Una pareja a false otra a true
            cartas.add(new Carta(String.valueOf(c), false));
            cartas.add(new Carta(String.valueOf(c), true));
        }
        
        //Dígitos
        for (char c = '0'; c <= '9'; c++)
        {
            //Dos cartas por número. Una pareja a false otra a true
            cartas.add(new Carta(String.valueOf(c), false));
            cartas.add(new Carta(String.valueOf(c), true));
        }
    }
    
    //Sacar carta random del conjunto (también la elimino)
    public Carta sacarCartaAleatoria()
    {
        if (cartas.isEmpty()) return null;
        
        Random random = new Random();
        int index = random.nextInt(cartas.size());
        
        Carta carta = cartas.get(index); //Obtengo la carta
        cartas.remove(carta);            //La elimino del conjunto
        return carta;                    //La devuelvo
    }
    
    //Busco la pareja de la aleatoria
    public Carta buscarPareja(Carta cartaOriginal) 
    {
        for (int i = 0; i < cartas.size(); i++) 
        {
            Carta carta = cartas.get(i);
            if (carta.getNombre().equals(cartaOriginal.getNombre()) && carta.isPareja() != cartaOriginal.isPareja()) 
            {
                cartas.remove(carta);  
                return carta;
            }
        }
        return null;
    }
        
    //Para conocer cuántas cartas quedan
    public int tamaño()
    {
        return cartas.size();
    }
    
    //Para comproprobar si la baraja está vacía o no
    public boolean estaVacia()
    {
        return cartas.isEmpty();
    }
}//Fin clase Baraja
