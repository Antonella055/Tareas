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
public class Lista_enlazada <E>{
    private Nodod<E> cabeza;

    public Lista_enlazada() {
        this.cabeza = null;
    }
    
    public void agregar(E valor){
        Nodod<E> nuevoNodo= new Nodod<> (valor); 
        if (cabeza==null){
            cabeza= nuevoNodo;
        }else{
            Nodod<E> actual= cabeza;
            while (actual.siguiente != null){
                actual= actual.siguiente;
            }
            actual.siguiente=nuevoNodo;
        }
    }
     public void eliminar(E valor) {
        if (cabeza != null) {
            if (cabeza.valor.equals(valor)) {
                cabeza = cabeza.siguiente;
            } else {
                Nodod<E> actual = cabeza;
                while (actual.siguiente != null && !actual.siguiente.valor.equals(valor)) {
                    actual = actual.siguiente;
                }
                if (actual.siguiente != null) {
                    actual.siguiente = actual.siguiente.siguiente;
                }
            }
        }
    }

    public void imprimirLista() {
        Nodod<E> actual = cabeza;
        while (actual != null) {
            System.out.println(actual.valor);
            actual = actual.siguiente;
        }
    }
}

