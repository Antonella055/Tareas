/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DoblementeEnlazada;

/**
 *
 * @author Antonella
 * @param <E>
 */
public class Nodo<E> {
    public int valor;
    public Nodo <E>siguiente;
    public Nodo<E> anterior;
    
    public Nodo(int valor) {
        this.valor = valor;
        this.siguiente = null;
        this.anterior = null;
    }

    public Nodo<E> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<E> siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo<E> getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo<E> anterior) {
        this.anterior = anterior;
    }
    
}

    

