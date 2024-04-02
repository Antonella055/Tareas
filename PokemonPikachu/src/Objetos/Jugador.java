/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import Estructuras.List;
import Interfaces.Auxiliar;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


/**
 *
 * @author Giuseppe
 */
public class Jugador {
    private int saldo;

    public Jugador() {
        this.saldo = new Auxiliar().obtenerWatts();
    }

    public int getSaldo() {
        return saldo;
    }
    
    public void incrementarSaldo(int cantidad) throws IOException {
        saldo += cantidad;
        new Auxiliar().procesaWatts(saldo);
    }
    
     public void decrementarSaldo(int cantidad) throws IOException {
        saldo -= cantidad;
         new Auxiliar().procesaWatts(saldo);
    }
     
   

}
