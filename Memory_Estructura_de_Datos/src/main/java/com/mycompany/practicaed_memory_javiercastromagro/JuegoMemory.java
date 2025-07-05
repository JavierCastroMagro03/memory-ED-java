/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaed_memory_javiercastromagro;

import java.util.Scanner;

/**
 * @author Usuario
 */
public class JuegoMemory {
    
    //ATRIBUTOS
    private Tablero tablero;
    private Baraja baraja;
    private Jugador jugador1;
    private Jugador jugador2;
    private Scanner sc; //Para leer por teclado
    
    //MÉTODOS
    //Para iniciar el juego
    public void iniciar()
    {
        sc = new Scanner(System.in); //Inicializo el scanner
        
        //Pedir dimensiones del tablero
        System.out.println("Empezamos definiendo el tamaño del tablero.");
        int columnas = pedirNumeroPar("Introduce el número par de columnas (entre 4 y 8): ", 4, 8);
        int filas = pedirNumero("Introduce el número de filas (entre 3 y 5): ", 3, 5);
        
        //Crear jugadores
        jugador1 = new Jugador("Jugador 1");
        jugador2 = new Jugador("Jugador 2");
        
        //Inicializo baraja y tablero
        baraja = new Baraja();
        baraja.inicializarBaraja();
        
        tablero = new Tablero(filas, columnas);
        tablero.inicializarTablero(baraja);
        
        Jugador jugadorActual = jugador1;
        
        //Bucle principal que se ejecuta mientras queden cartas por emparejar
        while(!tablero.todoRevelado())
        {
            System.out.println("\n" + jugadorActual.getNombre() + ", escoja una posición.");
            
            //Primera carta
            int[] pos1 = pedirCoordenadas(filas, columnas);
            Carta c1 = tablero.getCarta(pos1[0], pos1[1]);
            tablero.revelaCarta(pos1[0], pos1[1]);
            System.out.println("En la posición (" + pos1[1] + ", " + pos1[0] + ") se encuentra la carta " + c1.getNombre() + ".");
            
            //Segunda carta
            System.out.println(jugadorActual.getNombre() + ", escoja una posición.");
            int[] pos2 = pedirCoordenadas(filas, columnas);
            Carta c2 = tablero.getCarta(pos2[0], pos2[1]);
            tablero.revelaCarta(pos2[0], pos2[1]);
            System.out.println("En la posición (" + pos2[1] + ", " + pos2[0] + ") Se encuentra la carta " + c2.getNombre() + ".");
            
            //Muestra el tablero actual
            System.out.println("Mostrando el tablero de juego:");
            tablero.mostrarTableroRevelado();
            
            //Comprobamos si son pareja
            if (c1.getNombre().equals(c2.getNombre()))
            {
                System.out.println("¡Pareja encontrada!");
                jugadorActual.añadirCartaGanada(c1);
                jugadorActual.añadirCartaGanada(c2);
                //En caso de encontrar una pareja, el jugador repite turno
            }
            else 
            {
                //Si no acierta, se ocultan las cartas
                tablero.ocultarCarta(pos1[0], pos1[1]);
                tablero.ocultarCarta(pos2[0], pos2[1]);
                //Cambio de turno
                jugadorActual = (jugadorActual == jugador1) ? jugador2 : jugador1;
            }
        }
        
        //Cuando termina el juego, mostramos resultados
        mostrarResultado();
    }
    
    //Pedir número par (en el rango 4, 8)
    private int pedirNumeroPar(String mensaje, int min, int max)
    {
        int num;
        while(true)
        {
            System.out.println(mensaje);
            System.out.print("Por favor, introduzca un número: ");
            num = sc.nextInt();
            if(num >= min && num <= max && num % 2 == 0) break;
            System.out.println("Número inválido. Debe ser par y estar entre" + min + " y " + max + ".");
        }
        return num;
    }
    
    //Pedir número (en el rango 3, 5)
    private int pedirNumero(String mensaje, int min, int max)
    {
        int num;
        while(true)
        {
            System.out.println(mensaje);
            System.out.print("Por favor, introduzca un número: ");
            num = sc.nextInt();
            if(num >= min && num <= max) break;
            System.out.println("Número inválido. Debe estar entre" + min + " y " + max + ".");
        }
        return num;
    }
    
    //Pide coordenadas válidas dentro del tablero
    private int[] pedirCoordenadas(int filas, int columnas)
    {
        int col, fila;
        
        while(true)
        {
            System.out.print("Introduce una columnas entre 0 y " + (columnas - 1) + ": ");
            col = sc.nextInt();
            if(col >= 0 && col < columnas) break;
            System.out.println("Columna fuera de rango.");
        }
        
        while(true)
        {
            System.out.print("Introduce una fila entre 0 y " + (filas - 1) + ": ");
            fila = sc.nextInt();
            if(fila >= 0 && fila < filas) break;
            System.out.println("Fila fuera de rango.");
        }
        
        return new int[]{fila, col}; //Devuelvo primero la fila  y luego la columna
    }
    
    //Muestra el resultado final de la partida
    private void mostrarResultado()
    {
        System.out.println("\nEl " + jugador1.getNombre() + " ha descubierto las cartas:");
        jugador1.mostrarCartasGanadas();
        
        System.out.println("El " + jugador2.getNombre() + " ha descubierto las cartas:");
        jugador2.mostrarCartasGanadas();
        
        int p1 = jugador1.getCartasGanadas().size();
        int p2 = jugador2.getCartasGanadas().size();
        
        if (p1 > p2)
        {
            System.out.println("¡Gana " + jugador1.getNombre() + "!");
        }
        else if(p2 > p1)
        {
            System.out.println("¡Gana " + jugador2.getNombre() + "!");
        }
        else
        {
            System.out.println("¡Ha habido un empate!");
        }
    }  
}
