/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.practicaed_memory_javiercastromagro;

/**
 * @author Javier Castro Magro
 */
public interface SetG<E> {
    boolean add(E elem);       //Añadir un elemento al conjunto siempre y cuando no esté
    boolean contains(E elem);  //Para comprobar si un elemento está en el conjunto
    boolean remove(E elem);    //Para eliminar del conjunto un elemento concreto
    int size();                //Obtener el número de elementos del conjunto
    boolean isEmpty();         //Comprobar si el conjunto está vacío
    E get(int index);          //Obtener un elemento dado un índice (para cuando saque aleatoriamente)
}
