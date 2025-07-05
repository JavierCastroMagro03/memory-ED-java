/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaed_memory_javiercastromagro;

import java.util.Iterator;

/**
 * @author Javier Castro Magro
 */
public class ListArrayG<E> implements ListG<E>{
    //ATRIBUTOS     
    private E a[];
    private int capacity;
    private int size;
    
    //Constructor
    public ListArrayG(int capacity)
    {
        a = (E[]) new Object[capacity];
        this.capacity = capacity;
        size = 0;
    }

    //MÉTODOS
    @Override
    public void add(E elem) //simplemente añado nuevos elementos hacia la derecha
    {
        a[size] = elem;
        size++;
    }

    @Override
    public void add(int index, E elem) throws IndexOutOfBoundsException //Añado elemento en la posición que me indique el índice y desplazo todo lo demás
    {
        if (index > (size + 1)) throw new IndexOutOfBoundsException(); //La primera posición válida es la 0
        
        size++;
        for (int i = size; i < (index - 1); i--) 
        {
            a[i] = a[i - 1];
        }
        a[index] = elem;
    }

    @Override
    public int size() 
    {
        return size;
    }

    @Override
    public E set(int index, E elem) throws IndexOutOfBoundsException 
    {
        if (index > size) throw new IndexOutOfBoundsException();
        
        E tmp = a[index];
        a[index] = elem;
        return tmp;
    }

    @Override
    public boolean removeElem(E elem) //posible pregunta de examen pero con alguna variación cambiandonos un poco la lista
    {
        int i = indexOf(elem); // Ya tengo una referencia apuntando al elemento que quiero eliminar
        if (i == -1) return false;  // Si no está el elemento devuelvo false
        size--; // En el caso del último elemento el siguiente bucle nunca cumplirá la condición pero no hay ning´ún problema porque aquí ya movemos size uno a la izda por lo que no podrá copiar el elemento de la derecha(que no lo hay) porque nunca llegará a size
        for (; i < size; i++) 
        {
            a[i] = a[i + 1]; // Al usar estas condiciones comprobar que no me salga del array. En este caso no va a pasar nada por lo que expliqué antes.
        }
        return true;
    }

    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void clear() 
    {
        size = 0;
    }

    @Override
    public int indexOf(E elem) { // Devuelve el elemento de un indice concreto
        for (int i = 0; i <= size; i++) {
            if (a[i] == elem)
            {
                return i;
            }
        }
        return -1;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return a[index];
    }

    @Override
    public boolean contains(E elem) {
        for (int i = 0; i <= size; i++) {
                if (a[i] == elem)
                {
                    return true;
                }
            }
            return false;
    }

    @Override
    public boolean isEmpty() 
    {
        return size == 0;
    }

    @Override
    public boolean equals(ListG list) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
