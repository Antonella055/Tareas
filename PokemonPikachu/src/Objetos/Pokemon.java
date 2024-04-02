/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import Estructuras.List;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

/**
 *
 * @author Giuseppe
 */
public class Pokemon {
    private String nombre;
    private double relacion;
    private String estadoEmocional;
    private List<String> regalosRecibidos;

    public Pokemon(String nombre, int relacion, String estadoEmocional) {
        this.nombre = nombre;
        this.relacion = relacion;
        this.estadoEmocional = estadoEmocional;
        this.regalosRecibidos = new List<>();
    }

    // Getters y setters para acceder y modificar los atributos

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getRelacion() {
        return relacion;
    }

    public void setRelacion(int relacion) {
        this.relacion = relacion;
    }

    public String getEstadoEmocional() {
        return estadoEmocional;
    }

    public void setEstadoEmocional(String estadoEmocional) {
        this.estadoEmocional = estadoEmocional;
    }

    public List<String> getRegalosRecibidos() {
        return regalosRecibidos;
    }

    public void setRegalosRecibidos(List<String> regalosRecibidos) {
        this.regalosRecibidos = regalosRecibidos;
    }

  
    
    

}