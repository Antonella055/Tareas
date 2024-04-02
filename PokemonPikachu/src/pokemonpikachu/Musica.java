/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemonpikachu;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

/**
 *
 * @author Antonella
 */
public class Musica {
    private static Clip clip;
    
      public static void Reproducir(String rutaArchivo,float volumen) {
         try {
            File archivoMusica = new File(rutaArchivo);
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(archivoMusica));
            
            // Obtener el control de volumen
            FloatControl controlVolumen = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            
            // Establecer el volumen deseado
            controlVolumen.setValue(volumen);
            
            clip.start();
            
            // Reproducir la música en bucle 
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            
            // Pausar la ejecución del programa para que la música se reproduzca
            Thread.sleep(clip.getMicrosecondLength() / 1000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
      
     public static void Detener() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }
}
