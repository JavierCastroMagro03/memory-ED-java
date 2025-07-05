/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.practicaed_memory_javiercastromagro;

import java.util.Iterator;

/**
 * @author Javier Castro Magro
 */
public interface ListG<E> {
    public void add(E elem);
    public void add(int index, E elem) throws IndexOutOfBoundsException;
    public int size();
    public E set(int index, E elem) throws IndexOutOfBoundsException;
    public boolean removeElem(E elem);
    public Iterator iterator();
    public void clear();
    public int indexOf(E elem);
    public E get(int index) throws IndexOutOfBoundsException;
    public boolean contains(E elem);
    public boolean isEmpty();
    public boolean equals(ListG list);
}
