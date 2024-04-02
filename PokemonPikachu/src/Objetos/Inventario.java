/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import Estructuras.List;

/**
 *
 * @author Antonella
 */
public class Inventario extends Pokemon{
    List<String> regalos;
    
    public Inventario(String nombre, int relacion, String estadoEmocional,List<String> regalos) {
        super(nombre, relacion, estadoEmocional);
        this.regalos=regalos;
    }
    
}
