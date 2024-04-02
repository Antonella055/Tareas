/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import Objetos.Regalo;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Antonella
 */



public class ArbolAVL {
    public NodoAVL raiz;

    /**
     * Obtener la altura del arbol
     * @param NodoAVL nodos a evaluar 
     * @return  altura
     */
    public int obtenerAltura(NodoAVL NodoAVL) {
        if (NodoAVL == null) {
            return 0;
        }
        return NodoAVL.altura;
    }

    /**
     * Calcula el equilibrio de un nodo AVl
     * @param NodoAVL el nodo a calcular equilibrio
     * @return su equilibrio ( diferencia entre la altura del subárbol izquierdo y la altura del subárbol derecho)
     */
    public int obtenerBalance(NodoAVL NodoAVL) {
        if (NodoAVL == null) {
            return 0;
        }
        return obtenerAltura(NodoAVL.izquierdo) - obtenerAltura(NodoAVL.derecho);
    }

    /**
     * Rotacion Derecha
     * @param y
     * @return 
     */
    public NodoAVL rotarDerecha(NodoAVL y) {
        NodoAVL x = y.izquierdo;
        NodoAVL T2 = x.derecho;

        x.derecho = y;
        y.izquierdo = T2;

        y.altura = Math.max(obtenerAltura(y.izquierdo), obtenerAltura(y.derecho)) + 1;
        x.altura = Math.max(obtenerAltura(x.izquierdo), obtenerAltura(x.derecho)) + 1;

        return x;
    }

    /**
     * Rotacion izquierda
     * @param x
     * @return 
     */
    public NodoAVL rotarIzquierda(NodoAVL x) {
        NodoAVL y = x.derecho;
        NodoAVL T2 = y.izquierdo;

        y.izquierdo = x;
        x.derecho = T2;

        x.altura = Math.max(obtenerAltura(x.izquierdo), obtenerAltura(x.derecho)) + 1;
        y.altura = Math.max(obtenerAltura(y.izquierdo), obtenerAltura(y.derecho)) + 1;

        return y;
    }

    /**
     * insertar nodo
     * @param NodoAVL
     * @param nombreProducto Nombre del regalo
     * @param precio Precio del regalo
     * @return 
     */
    public NodoAVL insertar(NodoAVL NodoAVL, String nombreProducto, int precio) {
        if (NodoAVL == null) {
            return new NodoAVL(nombreProducto, precio);
        }

        if (nombreProducto.compareTo(NodoAVL.nombreProducto) < 0) {
            NodoAVL.izquierdo = insertar(NodoAVL.izquierdo, nombreProducto, precio);
        } else if (nombreProducto.compareTo(NodoAVL.nombreProducto) > 0) {
            NodoAVL.derecho = insertar(NodoAVL.derecho, nombreProducto, precio);
        } else {
            // El nombre del producto ya existe en el árbol
            return NodoAVL;
        }

        NodoAVL.altura = 1 + Math.max(obtenerAltura(NodoAVL.izquierdo), obtenerAltura(NodoAVL.derecho));

        int balance = obtenerBalance(NodoAVL);

        // Caso de rotación izquierda-izquierda
        if (balance > 1 && nombreProducto.compareTo(NodoAVL.izquierdo.nombreProducto) < 0) {
            return rotarDerecha(NodoAVL);
        }

        // Caso de rotación derecha-derecha
        if (balance < -1 && nombreProducto.compareTo(NodoAVL.derecho.nombreProducto) > 0) {
            return rotarIzquierda(NodoAVL);
        }

        // Caso de rotación izquierda-derecha
        if (balance > 1 && nombreProducto.compareTo(NodoAVL.izquierdo.nombreProducto) > 0) {
            NodoAVL.izquierdo = rotarIzquierda(NodoAVL.izquierdo);
            return rotarDerecha(NodoAVL);
        }

        // Caso de rotación derecha-izquierda
        if (balance < -1 && nombreProducto.compareTo(NodoAVL.derecho.nombreProducto) < 0) {
            NodoAVL.derecho = rotarDerecha(NodoAVL.derecho);
            return rotarIzquierda(NodoAVL);
        }

        return NodoAVL;
    }

    
    public void insertar(String nombreProducto, int precio) {
        raiz = insertar(raiz, nombreProducto, precio);
    }
    
    /**
     * recorrido inorden
     * @param nodo nodo a recorrer
     */
    public void recorridoInorden(NodoAVL nodo) {
        if (nodo != null) {
            recorridoInorden(nodo.izquierdo);
            System.out.println("Nombre: " + nodo.nombreProducto + ", Precio: " + nodo.precio);
            recorridoInorden(nodo.derecho);
        }
    }
    
    /**
     * imprime el arbol 
     * @param nodo
     * @param espacio 
     */
    public void imprimirArbol(NodoAVL nodo, String espacio) {
        if (nodo != null) {
            imprimirArbol(nodo.derecho, espacio + "   ");
            System.out.println(espacio + "|-- Nombre: " + nodo.nombreProducto + ", Precio: " + nodo.precio + ", Altura: " + nodo.altura);
            imprimirArbol(nodo.izquierdo, espacio + "   ");
        }
    }

    
    /**
     * Guarda el arbol de cada pokemon nodo por nodo
     * @param nodo
     * @param espacio
     * @param bufferedWriter Archivo txt de almacenamiento
     * @throws IOException 
     */
    private void guardarNodos(NodoAVL nodo, String espacio, BufferedWriter bufferedWriter) throws IOException {
    if (nodo != null) {
        guardarNodos(nodo.derecho, espacio + "   ", bufferedWriter);
        bufferedWriter.write(espacio + "|-- Nombre: " + nodo.nombreProducto + ", Precio: " + nodo.precio + ", Altura: " + nodo.altura + "\n");
        guardarNodos(nodo.izquierdo, espacio + "   ", bufferedWriter);
    }
}
    
    public void guardarArbolEnArchivo(NodoAVL nodo, String espacio, String nombrePokemon) {
    try {
        String nombreArchivo = nombrePokemon+ ".txt";
        FileWriter writer = new FileWriter(nombreArchivo);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        guardarNodos(nodo, espacio, bufferedWriter);

        bufferedWriter.close();
        
        File archivo = new File(nombreArchivo);
        archivo.deleteOnExit();
        
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    
    
}

   
    
