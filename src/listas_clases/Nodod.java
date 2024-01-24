/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listas_clases;

/**
 *
 * @author Antonella
 * @param <E>
 */
public class Nodod <E>{
    E valor;
    Nodod<E> siguiente;
    
    public Nodod(E valor){
        this.valor= valor;
        this.siguiente=null;
    }
}

