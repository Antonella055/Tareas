/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import Estructuras.List;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Antonella
 */
public class Pokemon {
    private String nombre;
    private int relacion;
    private List<String> regalosRecibidos;

    public Pokemon(String nombre) {
        this.nombre = nombre;
        this.relacion = 0;
        this.regalosRecibidos = new List<>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getRelacion() {
        return relacion;
    }

    public List<String> getRegalosRecibidos() {
        return regalosRecibidos;
    }

    public void aumentarRelacion(int cantidad) {
        relacion += cantidad;
    }

    public void disminuirRelacion(int cantidad) {
        relacion -= cantidad;
        if (relacion < 0) {
            relacion = 0;
        }
    }

    public void recibirRegalo(String regalo) {
        regalosRecibidos.insertarFinal(regalo);
    }

    public boolean jugarAdivinanza() {
        if (regalosRecibidos.getSize() < 2) {
            System.out.println("Lo siento, no tengo suficientes regalos para jugar contigo.");
            return false;
        }

        Random rand = new Random();
        int regaloElegido = rand.nextInt(regalosRecibidos.getSize());

        System.out.println("Piensa en un regalo que me hayas dado y trataré de adivinarlo...");

        int usuarioEligeRegalo = 0; // interacción con el usuario para que elija el regalo

        if (usuarioEligeRegalo == regaloElegido) {
            JOptionPane.showMessageDialog(null, "¡Has adivinado! Gracias por pensar en mí.");
            aumentarRelacion(1); // Aumenta la relación
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Lo siento, esa no es la respuesta correcta.");
            disminuirRelacion(1); // Disminuye la relación
            return false;
        }
    }
}