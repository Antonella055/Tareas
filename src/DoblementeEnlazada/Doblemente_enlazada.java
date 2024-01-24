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
public class Doblemente_enlazada <E>{
    private Nodo<E> cabeza;
    private Nodo<E> cola;

    public Doblemente_enlazada(Nodo cabeza, Nodo cola) {
        this.cabeza = null;
        this.cola = null;
    }
    
    public void insertar(int valor){// al final
        Nodo<E> nuevoNodo=new Nodo<>(valor);
        
        if(cabeza==null){
            cabeza=nuevoNodo;
            cola=nuevoNodo;
        }else{
            nuevoNodo.anterior=cola;
            cola.siguiente=nuevoNodo;
            cola=nuevoNodo;
        }
    }
    
    public Nodo buscar(int valor){
          Nodo<E> nodoActual = cabeza;
        
        while (nodoActual != null) {
            if (nodoActual.valor == valor) {
                return nodoActual;
            }
            nodoActual = nodoActual.siguiente;
        }
        
        return null; // Si no se encuentra el valor en la lista
    }
    
    public void eliminar(int valor){
        Nodo nodoActual = cabeza;
        
        while (nodoActual != null) { //mientras haya nodos en la lista que aún no se hayan recorrido.
            if (nodoActual.valor == valor) { //si el valor del nodo actual es igual al valor buscado.
                if (nodoActual == cabeza) { //si el nodo actual es la cabeza de la lista.
                    cabeza = nodoActual.siguiente; //se actualiza la referencia de la cabeza para que apunte al siguiente nodo
                    if (cabeza != null) {
                        cabeza.anterior = null; //se establece el enlace anterior del nuevo nodo de la cabeza como nulo.
                    }
                } else if (nodoActual == cola) { //Si el nodo actual no es la cabeza, se verifica si es la cola de la lista.
                    cola = nodoActual.anterior; //se actualiza la referencia de la cola para que apunte al nodo anterior
                    if (cola != null) {
                        cola.siguiente = null; //se establece el enlace siguiente del nuevo nodo de la cola como nulo.
                    }
                } else {
                    //Se actualiza el enlace siguiente del nodo anterior para que apunte al siguiente nodo después del nodo actual.
                    nodoActual.anterior.siguiente = nodoActual.siguiente;
                    
                    // Se actualiza el enlace anterior del nodo siguiente para que apunte al nodo anterior al nodo actual
                    nodoActual.siguiente.anterior = nodoActual.anterior;
                }
                break;
            }
            nodoActual = nodoActual.siguiente; //Se actualiza nodoActual para que apunte al siguiente nodo en la lista y continuar con la siguiente iteración del bucle.
        }
    }
    }

