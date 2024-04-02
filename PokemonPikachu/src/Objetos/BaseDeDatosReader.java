/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JComboBox;

/**
 *
 * @author Adriana Aguilera
 */

public class BaseDeDatosReader {//Leer pokemons disponibles en el programa
    public void ObtenerPokemonsDisponibles(JComboBox<String> comboBox) {
        String nombreArchivo = "BaseDatosPokemons.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(" ");
                comboBox.addItem(partes[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    
}
