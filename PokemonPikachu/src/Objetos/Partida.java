/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import Interfaces.Auxiliar;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Adriana Aguilera
 */
public class Partida {
    public static void guardarPartida() {
        String archivoInfoPartida = "InfoPartida.txt";
        String archivoTemporal = "temporal.txt";
        String archivoPartidaGuardada = "PARTIDAGUARDADA.txt";

        try (BufferedReader readerInfoPartida = new BufferedReader(new FileReader(archivoInfoPartida));
             BufferedReader readerTemporal = new BufferedReader(new FileReader(archivoTemporal));
             BufferedWriter writer = new BufferedWriter(new FileWriter(archivoPartidaGuardada))) {

            String lineaInfoPartida;
            String lineaTemporal;

            // Leer la información de InfoPartida.txt
            while ((lineaInfoPartida = readerInfoPartida.readLine()) != null) {
                if (lineaInfoPartida.contains("Pokemon:") && lineaInfoPartida.contains("Regalos:") &&
                        lineaInfoPartida.contains("Relacion:") && lineaInfoPartida.contains("Estado:")) {
                    writer.write(lineaInfoPartida + ", ");
                    break;
                }
            }

            // Leer la información de temporal.txt
            while ((lineaTemporal = readerTemporal.readLine()) != null) {
                if (lineaTemporal.contains("Relacion:") && lineaTemporal.contains("Pokemon:") &&
                        lineaTemporal.contains("Inventario:")) {
                    String inventario = lineaTemporal.substring(lineaTemporal.indexOf("[") + 1, lineaTemporal.indexOf("]"));
                    writer.write("Watts: " + new Auxiliar().obtenerWatts());
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        public static String LeerPartida(String direccionArchivo) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(direccionArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                sb.append(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

   public static String obtWatts(String texto) {
        String valorWatts = "";

        if (texto.contains("Watts:")) {
            int indiceInicio = texto.indexOf("Watts:") + 7;
            int indiceFin = texto.indexOf(" ", indiceInicio);
            if (indiceFin == -1) {
                indiceFin = texto.length();
            }
            valorWatts = texto.substring(indiceInicio, indiceFin).trim();
        }
        System.out.println(valorWatts);
        return valorWatts;
    }
   
   
   public static String obtValor(String texto, String atributo) {
    String valor = "";

    if (texto.contains(atributo + ":")) {
        int indiceInicio = texto.indexOf(atributo + ":") + atributo.length() + 1;
        int indiceFin = texto.indexOf(",", indiceInicio);
        if (indiceFin == -1) {
            indiceFin = texto.length();
        }
        valor = texto.substring(indiceInicio, indiceFin).trim();
    }
    System.out.println(valor);
    return valor;
}

}