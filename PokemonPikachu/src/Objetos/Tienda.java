/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import Estructuras.List;
import Interfaces.Auxiliar;

/**
 *
 * @author Antonella
 */
public class Tienda {

    private List<Regalo> regalosDisponibles;

    public Tienda() {
        regalosDisponibles = new List<>();
        // Agregar regalos disponibles en la tienda
        regalosDisponibles.insertarFinal(new Regalo("Baya Aranja", 100)); 
        regalosDisponibles.insertarFinal(new Regalo("Baya Caquic", 200));
        regalosDisponibles.insertarFinal(new Regalo("Poke ball", 300));
        regalosDisponibles.insertarFinal(new Regalo("Baya Zezra", 400));
        regalosDisponibles.insertarFinal(new Regalo("baya Zanama", 500));
        regalosDisponibles.insertarFinal(new Regalo("baya Ziuela", 600));
        regalosDisponibles.insertarFinal(new Regalo("Baya Zidra", 700));
        regalosDisponibles.insertarFinal(new Regalo("Baya Enigma", 800));
        regalosDisponibles.insertarFinal(new Regalo("Caramelo raro", 900));
    }

    public List<Regalo> getRegalosDisponibles() {
        return regalosDisponibles;
    }

    public void mostrarRegalosDisponibles() {
        System.out.println("Regalos disponibles en la tienda:");
        for (int i = 0; i < regalosDisponibles.getSize(); i++) {
            System.out.println((i + 1) + ". " + regalosDisponibles.get(i));
        }
    }

    public Regalo comprarRegalo(int indice) {
        if (indice >= 0 && indice < regalosDisponibles.getSize()) {
            return regalosDisponibles.get(indice);
        } else {
            System.out.println("Índice de regalo no válido.");
            return null;
        }
    }
    
        
}
    

