/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author Giuseppe Vaccaro
 */
public class Nodo<T> {
    //--------------------/ Atributos /------------------------
    private T dato;
    private Nodo siguiente;
    
    //-------------------/ Constructor /----------------------
    /***
     * Constructor de la clase Nodo
     * Se le pasa el dato del nodo por parametro
     * @param dato 
     */
    public Nodo(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }
    
    //-----------------------/ Metodos /-----------------------
    /**
     * Obtiene el dato del nodo
     * @return 
     */
    public T getDato() {
        return dato;
    }
    
    /**
     * Cambia el dato del nodo
     * @param dato 
     */
    public void setDato(T dato) {
        this.dato = dato;
    }
    
    /**
     * Obtiene el siguiente del nodo
     * @return 
     */
    public Nodo getSiguiente() {
        return siguiente;
    }
    
    /**
     * Cambia el siguiente del nodo
     * @param siguiente 
     */
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    
    
    
    
    
    
    
    
}
