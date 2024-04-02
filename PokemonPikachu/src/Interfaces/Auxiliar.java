/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Estructuras.List;
import Estructuras.TablaHash;
import Objetos.Pokemon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author Antonella
 */
public class Auxiliar {
    private boolean imprimirWatts = true; // Controla si se debe imprimir los watts o no
    private int wattsRegistrados; // Almacena los watts leídos del archivo
    private List<String>Inventario;

    
    

    public void procesaWatts(int watts) throws IOException {
        FileWriter writer = new FileWriter("watts.txt");
        if (ImprimirWatts()) {
      
            imprimirWatts = false;

            try {
                BufferedWriter buffer = new BufferedWriter(writer);

                buffer.write(String.valueOf(watts));
                buffer.close();
            
            } catch (IOException e) {
                System.out.println("Error al guardar los watts ");
                e.printStackTrace();
            }
        }
    }

 
    
    
    
    public int obtenerWatts() {
        try (BufferedReader br = new BufferedReader(new FileReader("watts.txt"))) {
            wattsRegistrados = Integer.parseInt(br.readLine());
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error al leer el archivo watts.txt o formato no válido");
            e.printStackTrace();
        }
        return wattsRegistrados;
    }

    public void debeImprimirWatts(boolean valor) {
        imprimirWatts = valor;
    }

    public boolean ImprimirWatts() {
        return imprimirWatts;
    }
    
     public List<String> cargarInventario() {
         Inventario= new List<>();
        // Implementa la lógica para cargar el inventario desde el archivo
        try {
            // Especifica la ruta y el nombre del archivo
            String rutaArchivo = "Inventario.txt";

            // Crea un BufferedReader para leer el archivo
            try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
                String linea;
                while ((linea = reader.readLine()) != null) {
                    // Agrega cada línea leída del archivo al inventario
                    Inventario.insertarFinal(linea);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return Inventario;
    }
     
     
     
     
     //Informacion Pokemon Almacenada
     public static void escribirPokemon(String pokemon) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("temporal.txt", true))) {
            writer.write(", Pokemon: " + pokemon);
        }
    }
     
    public static void escribirInventario(List<String> inventario) throws IOException{
        try (BufferedWriter writer= new BufferedWriter(new FileWriter("temporal.txt",true))){
            writer.write(", Inventario: [");
            for (int i = 0; i < inventario.getSize(); i++) {
                writer.write(inventario.get(i));
                if (i< inventario.getSize()-1) {
                    writer.write(", ");
                }
            }
            writer.write("]");
    }
    }
    
    
    //Informacion Pokemon
    public static String leerRelacion() throws IOException{
         try (BufferedReader reader= new BufferedReader(new FileReader("temporal.txt"))) {
             String linea=reader.readLine();
             if (linea!= null && linea.startsWith("Relacion:")) {
                 return linea.substring(9).trim();
             }
         }
         return null;
    }
    
    public static String leerPokemon() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("temporal.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                if (linea.startsWith(", Pokemon:")) {
                    return linea.substring(9).trim();
                }
            }
        }
        return null;
    }
     public static String[] leerInventario() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("temporal.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                if (linea.startsWith(", Inventario:")) {
                    String inventarioString = linea.substring(13, linea.length() - 1).trim();
                    return inventarioString.split(", ");
                }
            }
        }
        return null;
    }
     
     
     
     //Almacenamiento de la partida DatosPokemon
      public void transferirDatos() throws IOException {
        File archivoTemporal = new File("temporal.txt");
        File archivoInfoPartida = new File("InfoPartida.txt");

        if (!archivoTemporal.exists()) {
            System.out.println("El archivo temporal no existe.");
            return;
        }

        // Leemos el archivo temporal y transferimos la información 
        try (BufferedReader reader = new BufferedReader(new FileReader(archivoTemporal));
             BufferedWriter writer = new BufferedWriter(new FileWriter(archivoInfoPartida, true))) {

            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                String pokemon =  obtener(partes[1].trim()); // El Pokémon se encuentra en la segunda parte
                String relacion = obtenerRelacion(partes[0].trim()); // La relación se encuentra en la primera parte
                String[] inventarioItems =obtenerInventario( partes[2].trim()); // El inventario se encuentra en la tercera parte

                if (pokemonExisteEnInfoPartida(archivoInfoPartida, pokemon)) {
                    // Si el Pokémon ya existe en InfoPartida.txt, actualizamos su información
                    String estado= obtenerEstadoAnimo(Integer.parseInt(relacion));
                    actualizarInfoPartida(archivoInfoPartida, pokemon, relacion, inventarioItems,estado);
                } else {
                   String estado = obtenerEstadoAnimo(Integer.parseInt(relacion));
                 // salto de línea antes de la nueva entrad
                 String inventario= convertirToString(inventarioItems);
                writer.write("Pokemon: " + pokemon + ", Regalos: " +  convertirToString(inventarioItems) + ", Relacion: " + relacion + ", Estado:" + estado + " \n");
                Pokemon pokemonObjeto = new Pokemon(pokemon, Integer.parseInt(relacion), estado);
            }}
        }
    }
      
      
      public String convertirToString(String[] inventario) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < inventario.length; i++) {
        sb.append(inventario[i]);
        if (i < inventario.length - 1) {
            sb.append(", ");
        }
    }
    return sb.toString();
}
      

     private static String obtener(String linea) {
    // Buscamos el índice del primer ':' para obtener el dato sin indices
    int indiceSeparador = linea.indexOf(':');
    if (indiceSeparador != -1) {
        return linea.substring(indiceSeparador + 1).trim();
    } else {
         return linea.trim();  // Si no se encuentra el separador, retornamos una cadena vacía
    }
      
     }
     private static String[] obtenerInventario(String datos) {
    String inventarioLimpio=datos.substring(11,datos.length()-1);
    String[] inventario= inventarioLimpio.split(",");
    return inventario;
     }
     
      private static String obtenerRelacion(String linea) {
    // Buscamos el índice del primer ':' para obtener el dato sin indices
    int indiceRelacion = linea.indexOf("Relacion:");
    if (indiceRelacion != -1) {
        // Obtenemos la parte de la cadena después de "Relacion:" y eliminamos los espacios en blanco
        String parteDespuesDeRelacion = linea.substring(indiceRelacion + "Relacion:".length()).trim();
        // Retornamos la parte después de "Relacion:" directamente
        return parteDespuesDeRelacion;
    }
    // Si no se encuentra la cadena "Relacion:", retornamos una cadena vacía
    return "";
}
      
      
    private static boolean pokemonExisteEnInfoPartida(File archivoInfoPartida, String pokemon) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivoInfoPartida))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                if (linea.startsWith("Pokemon:") && linea.contains(pokemon)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void actualizarInfoPartida(File archivoInfoPartida, String pokemon, String nuevaRelacion, String[] nuevoInventario,String estado) throws IOException {
        // Creamos un archivo temporal para almacenar las líneas actualizadas
       File archivoTemporal = new File("Partida.txt");
    try (BufferedReader reader = new BufferedReader(new FileReader(archivoInfoPartida));
         BufferedWriter writer = new BufferedWriter(new FileWriter(archivoTemporal))) {

        String linea;
        boolean pokemonEncontrado = false;
        while ((linea = reader.readLine()) != null) {
            if (linea.startsWith("Pokemon:") && linea.contains(pokemon)) {
                // Si encontramos el Pokémon, actualizamos su información
                String[] partes = linea.split(", ");
                if (partes.length >= 4 && partes[2].startsWith("Relacion:")) {
                    String relacionExistente = obtener(partes[2].substring(9).trim()); // Obtener la relación existente
                    int nuevaRelacionEntera = Integer.parseInt(relacionExistente.trim()) + Integer.parseInt(nuevaRelacion);

                    String nuevaLinea = "Pokemon: " + pokemon + ", Regalos: " + nuevoInventario + ", Relacion: " + nuevaRelacionEntera + ", Estado: " + estado + " \n";

                    writer.write(nuevaLinea);
                    pokemonEncontrado = true;
                }
            } else {
                // Si no es el Pokémon que buscamos, escribimos la línea tal como está
                writer.write(linea);
                writer.newLine();
            }
        }

        if (!pokemonEncontrado) {
            // Si el Pokémon no se encontró en el archivo, agregamos una nueva entrada
            String nuevaLinea = "Pokemon: " + pokemon + ", Regalos: " + nuevoInventario + ", Relacion: " + nuevaRelacion + ", Estado: " + estado + " \n";
            writer.write(nuevaLinea);
        }
    }

  
    archivoTemporal.renameTo(archivoInfoPartida);

    }
    
    //LOGICA ESTADO
    public static String obtenerEstadoAnimo(int relacion) {
            // Determinar en qué rango se encuentra el valor de la relación
            if (relacion >= 0 && relacion < 2000) {
                return "Sigh";
            } else if (relacion >= 2000 && relacion < 4000) {
                return "Angry";
            } else if (relacion >= 4000 && relacion < 6000) {
                return "Normal";
            } else if (relacion >= 6000 && relacion < 8000) {
                return "Happy";
            } else if (relacion >= 8000 && relacion <= 10000) {
                return "Inspired";
            } else {
                // En caso de que el valor de la relación esté fuera de los rangos especificados
                return "Desconocido";
            }
        }
    
    //leer datos de la partida 
      public  String leerNombre(String archivo) {
    String nombre = "";
    try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] partes = linea.split(","); 
            nombre = partes[0].substring(partes[0].indexOf(":") + 1).trim();
            break; 
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return nombre;
}
   public String leerEstado(String archivo) {
    String estado = "";
     boolean lineaEnBlanco = false;
  
    try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
        String linea;
        
        while ((linea = br.readLine()) != null) {
            if (linea.trim().isEmpty()) { // Verificar si la línea está en blanco
                lineaEnBlanco=true;
                continue;
            }
            if (linea.startsWith("Estado:") && lineaEnBlanco) { // Verificar si se encontró la línea de estado
;
                String[] partes = linea.split(",");
                estado = partes[3].substring(partes[3].indexOf(":") + 1).trim();
                
                break;
            }
        }
        
    } catch (IOException e) {
        e.printStackTrace();
    }
    return estado;
}

public String leerRelacion(String archivo) {
    String relacion = "";
    boolean encontradaLineaRelacion = false;
    try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            if (linea.trim().isEmpty()) { // Verificar si la línea está en blanco
                continue;
            }
            if (linea.contains("Relacion:")) { // Verificar si se encontró la línea de relación
                String[] partes = linea.split(",");
                for (String parte : partes) {
                    if (parte.trim().startsWith("Relacion:")) {
                        relacion = parte.substring(parte.indexOf(":") + 1).trim();
                        encontradaLineaRelacion = true;
                        break;
                    }
                }
            }
            if (encontradaLineaRelacion) {
                break;
            }
        }
      
    } catch (IOException e) {
        e.printStackTrace();
    }
    return relacion;
}
    
     public  List<String> leerRegalos(String archivo) {
        List<String> regalos = new List<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            boolean lineaEnBlanco = false;
            boolean encontradaLineaRegalos = false;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) { // Verificar si la línea está en blanco
                lineaEnBlanco = true;
                continue;
            }
                if (linea.startsWith("Regalos:")) {
                    encontradaLineaRegalos = true;
                    continue;}
                
                    if (lineaEnBlanco && encontradaLineaRegalos) { // Si hay una línea en blanco y se encontró la línea de regalos
                String[] regalosArray = linea.split(", ");
                for (int i = 0; i < regalosArray.length; i++) {
                    regalos.insertarFinal(regalosArray[i]);
                }
                break; // Leer solo la primera línea que contiene los regalos
            }
        }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return regalos;
    }

    public List<String> obtDatosPokemon(String nombrePokemon){
        List<String> datospokemon=new List<>();
        String archivoInfo= "InfoPartida.txt";
        
        try  (BufferedReader reader= new BufferedReader(new FileReader(archivoInfo))){
            String linea;
            while ((linea  = reader.readLine()) != null){
                if(linea.startsWith("Pokemon:"+ nombrePokemon)){
                    datospokemon.insertarFinal(linea);}
            }
        }catch(IOException e){
            e.printStackTrace();
        }
            return datospokemon;
    }
    
    //Auxiliares archivos temporales
     public void saveToTxt(String data, String filePath) {
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                bufferedWriter.write(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     
    public String readFromTxt(String filePath) {
        StringBuilder content = new StringBuilder();
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line).append("\n");
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }
     public boolean fileExists(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }
     
    public static void duplicar(String archivoOriginal,String copia) throws FileNotFoundException, IOException{
        try (InputStream in=new FileInputStream(archivoOriginal); OutputStream out= new FileOutputStream(copia)){
            
            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            System.out.println("ArchivoCopiado con exito");
            
        }catch (IOException e) {
            System.out.println("Error al duplicar el archivo: " + e.getMessage());
        }
    

    }
    
    
}
     

    

