/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;



/**
 *
 * @author Antonella
 */
public class NodoAVL {
    String nombreProducto;
    int precio;
    int altura;
    NodoAVL izquierdo;
    NodoAVL derecho;

    public NodoAVL(String nombreProducto, int precio) {
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.altura = 1;
    }

}
