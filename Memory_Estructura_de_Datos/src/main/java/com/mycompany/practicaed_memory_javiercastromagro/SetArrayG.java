/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaed_memory_javiercastromagro;

/**
 * @author Javier Castro Magro
 */
public class SetArrayG<E> implements SetG<E> {
    //ATRIBUTOS 
    private E elementos[]; //array para guardar  los elementos
    private int cardinal; //número de elementos actual en el conjunto
    
    //CONSTRUCTOR
    public SetArrayG()
    {
        elementos = (E[]) new Object[100]; //Capacidad inicial
        cardinal = 0;
    }
    
    //MÉTODOS
    @Override
    public boolean add(E elem) 
    {
        if(!contains(elem))
        {
            elementos[cardinal] = elem;
            cardinal++;
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(E elem) 
    {
        for (int i = 0; i < cardinal; i++) 
        {
            if(elementos[i].equals(elem))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(E elem) {
        for (int i = 0; i < cardinal; i++) 
        {
            if(elementos[i].equals(elem))
            {
                //Desplazamos los elementos a la izda
                for (int j = 0; j < cardinal; j++) 
                {
                    elementos[j] = elementos[j + 1];
                }
                cardinal--;
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return cardinal;
    }

    @Override
    public boolean isEmpty() {
        return cardinal == 0;
    }

    @Override
    public E get(int index) {
        if(index < 0 || index >= cardinal) throw new IndexOutOfBoundsException();
        return elementos[index];
    }
}//Fin clase SetArrayG<E>
