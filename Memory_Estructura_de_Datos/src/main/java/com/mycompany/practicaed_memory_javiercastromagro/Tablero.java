/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaed_memory_javiercastromagro;

import java.util.Random;

/**
 * @author Javier Castro Magro
 */
public class Tablero {
    //ATRIBUTOS
    private int filas;
    private int columnas;
    private Carta[][] tablero;
    
    //CONSTRUCTOR
    public Tablero(int filas, int columnas)
    {
        this.filas = filas;
        this.columnas = columnas;
        tablero = new Carta[filas][columnas];
    }
    
    //MÉTODOS
    //Inicializar tablero con las cartas obtenidas de la baraja
    public void inicializarTablero(Baraja baraja)
    {
        int totalCartas = filas * columnas;
        
        //Array temporal para las cartas antes de mezclarlas
        Carta[] cartasMezcladas = new Carta[totalCartas];
        
        //Sacamos las parejas y las añadimos al array
        int index = 0;
        while (index < totalCartas)
        {
            Carta c1 = baraja.sacarCartaAleatoria();
            Carta c2 = baraja.buscarPareja(c1);
            cartasMezcladas[index++] = c1;
            cartasMezcladas[index++] = c2;
        }
        
        //Mezclar cartas
        Random random = new Random();
        for (int i = cartasMezcladas.length -1; i > 0; i--) 
        {
            int j = random.nextInt(i + 1);
            Carta temp = cartasMezcladas[i];
            cartasMezcladas[i] = cartasMezcladas[j];
            cartasMezcladas[j] = temp;
        }
        
        //Distribuir las cartas en el tablero
        index = 0;
        for (int fila = 0; fila < filas; fila++) 
        {
            for (int col = 0; col < columnas; col++) 
            {
                tablero[fila][col] = cartasMezcladas[index++];
            }
        }
        
    }//Fin método inicializarTablero
    
    //Revelar carta en posición indicada
    public void revelaCarta(int fila, int columna)
    {
        tablero[fila][columna].setRevelada(true);
    }
    
    //Mostrar tablero por consola
    public void mostrarTableroRevelado()
    {
        for (int fila = 0; fila < filas; fila++)
        {
            for (int col = 0; col < columnas; col++)
            {
                Carta carta = tablero[fila][col];
                System.out.print(carta + " ");
            }
            System.out.println();
        }
    }
    
    
    //Juego terminado si todas las cartas están reveladas
    public boolean todoRevelado()
    {
        for (int fila = 0; fila < filas; fila++)
        {
            for (int col = 0; col < columnas; col++)
            {
                if (!tablero[fila][col].isRevelada())
                {
                    return false;
                }
            }
        }
        return true;
    }
    
    
    //Acceder a carta concreta
    public Carta getCarta(int fila, int columna)
    {
        return tablero[fila][columna];
    }
    
    
    //Ocultar carta en caso de no formar pareja
    public void ocultarCarta(int fila, int columna) 
    {
        tablero[fila][columna].setRevelada(false);
    }
}//Fin clase Tablero
