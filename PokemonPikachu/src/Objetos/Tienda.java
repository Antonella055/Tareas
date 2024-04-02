/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import Estructuras.List;
import Interfaces.Auxiliar;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Antonella
 */
public class Tienda {

    private List<Regalo> regalosDisponibles;

    public Tienda() {
        regalosDisponibles = new List<>();
        // Agregar regalos disponibles en la tienda
        
         try {
            File archivo = new File("prueba.txt");  //prueba.txt contiene la base de datos de la tienda
            Scanner scanner = new Scanner(archivo);

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] datos = linea.split(",");

                String nombre = datos[0].trim();
                int valor = Integer.parseInt(datos[1].trim());
                regalosDisponibles.insertarFinal(new Regalo(nombre, valor));
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        
        
        
        
//        regalosDisponibles.insertarFinal(new Regalo("Baya Aranja", 100)); 
//        regalosDisponibles.insertarFinal(new Regalo("Baya Caquic", 200));
//        regalosDisponibles.insertarFinal(new Regalo("Poke ball", 300));
//        regalosDisponibles.insertarFinal(new Regalo("Baya Zezra", 400));
//        regalosDisponibles.insertarFinal(new Regalo("baya Zanama", 500));
//        regalosDisponibles.insertarFinal(new Regalo("baya Ziuela", 600));
//        regalosDisponibles.insertarFinal(new Regalo("Baya Zidra", 700));
//        regalosDisponibles.insertarFinal(new Regalo("Baya Enigma", 800));
//        regalosDisponibles.insertarFinal(new Regalo("Caramelo raro", 900));
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
    

