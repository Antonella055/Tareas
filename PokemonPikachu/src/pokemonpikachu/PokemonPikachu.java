/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pokemonpikachu;

import Interfaces.MenuInicial;
import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author Antonella
 */
public class PokemonPikachu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
       new MenuInicial().setVisible(true);
      

       String file="watts.txt";
       File archiv=new File(file);
       archiv.deleteOnExit();
       
    }
    
   
    
}
