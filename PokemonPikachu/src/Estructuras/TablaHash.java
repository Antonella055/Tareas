/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author Giuseppe Vaccaro
 */
public class TablaHash {
    //---------------------/ Atributos /----------------------
    private Lista[] tabla;
    private int capacidad;
    
    //-------------------/ Construcotr /----------------------
    /**
     * Constructor de la clase TablaHash
     * @param capacidad 
     */
    public TablaHash(int capacidad) {
        this.tabla = new Lista[capacidad];
        this.capacidad = capacidad;
        
        for (int i = 0; i < capacidad; i++) {
            tabla[i] = new Lista();
        }
    }

    //---------------------/ Metodos /------------------------
    /**
     * Obtiene el arreglo de listas de la tabla de dispersion
     * @return 
     */
    public Lista[] getTabla() {
        return tabla;
    }
    
    /**
     * Cambia el arreglo de listas de la tabla de dispersion
     * @param tabla 
     */
    public void setTabla(Lista[] tabla) {
        this.tabla = tabla;
    }
    
    /**
     * Obtiene la capacidad de la tabla de dispersion
     * @return 
     */
    public int getCapacidad() {
        return capacidad;
    }
    
    /**
     * Cambia la capacidad de la tabla de dispersion
     * @param capacidad 
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
    /**
     * Obtiene el codigo hash dado un nombre y un apellido
     * @param nombre
     * @param apellido
     * @return 
     */
    public int codigoHash(String nombre, String apellido){
        int codigo = 0;
        
        for (int i = 0; i < nombre.length(); i++) {
            int valorNumerico = nombre.charAt(i);
            codigo += valorNumerico;
        }
        
        for (int i = 0; i < apellido.length(); i++) {
            int valorNumerico = apellido.charAt(i);
            codigo += valorNumerico;
        }
        
        return codigo % getCapacidad();
    }
    
    
    

    
    
    
    
    
    
}
