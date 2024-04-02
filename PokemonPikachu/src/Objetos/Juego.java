/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import Estructuras.List;
import Interfaces.Auxiliar;

import Interfaces.MenuPrincipal;

import java.io.IOException;
import java.util.Random;

import javax.swing.JDialog;

import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author Antonella
 */
public class Juego {
     int Watts;
    int Relacion;
    private Jugador jugador;
    public boolean Aumentar;

    
  
    public Juego() {
        this.Watts= new Auxiliar().obtenerWatts();
        this.jugador = new Jugador();
        this.Aumentar=false;
        
    }
    
     private int CantidadApostada(String mensaje, int saldoActual) {
        JSpinner spinner = new JSpinner(new SpinnerNumberModel(0, 0, saldoActual, 1));
        int opcion = JOptionPane.showOptionDialog(
                null,
                spinner,
                mensaje,
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                null);

        if (opcion == JOptionPane.OK_OPTION) {
            return (int) spinner.getValue();
        } else {
            return -1; // El jugador canceló la selección
        }
    }

    
    public void jugarCartaMasAlta() throws IOException {
        
         boolean jugadorGano= false;
        //Cantidad de la apuesta
        int cantidadApostada = CantidadApostada("Seleccione la cantidad de watts para apostar", jugador.getSaldo());
        // Verificar si el jugador canceló la selección o si la cantidad seleccionada excede su saldo
        if (cantidadApostada == -1 || cantidadApostada > jugador.getSaldo()) {
            JOptionPane.showMessageDialog(null, "Apuesta inválida. Por favor, seleccione una cantidad válida.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        System.out.println("Saldo previo"+jugador.getSaldo());
        //REstarle el saldo que aposto
        jugador.decrementarSaldo(cantidadApostada);
        
       
        

        Watts=jugador.getSaldo();
        // Generar el número aleatorio de la carta escogida por el Pokémon
        int cartaPokemon = generarCartaAleatoria();
        String mensajeCartaPokemon = "Pikachu ha escogido la carta número " + cartaPokemon;
        JOptionPane.showMessageDialog(null, mensajeCartaPokemon);


         //validacion si se cierra la primera ventana
        JOptionPane optionPane = new JOptionPane(mensajeCartaPokemon, JOptionPane.INFORMATION_MESSAGE);
         JDialog dialog = optionPane.createDialog("Carta más alta");
        if (mensajeCartaPokemon == null) {
            return;
        }
        

        // Permitir al usuario seleccionar si piensa que la próxima carta será más alta o más baja
        int opcionElegida = JOptionPane.showOptionDialog(
                null,
                "¿La próxima carta será más alta o más baja?",
                "Carta más alta",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new String[]{"Más alta", "Más baja"},
                "Más alta");
        
            // Si el usuario cierra la ventana, termina el juego
        if (opcionElegida == JOptionPane.CLOSED_OPTION) {
            return;
        }
        
        
        // Generar otro número aleatorio y mostrarlo al jugador
        int nuevaCarta = generarCartaAleatoria();
        String mensajeNuevaCarta = "La nueva carta es " + nuevaCarta;
        JOptionPane.showMessageDialog(null, mensajeNuevaCarta);

        // Determinar el resultado del juego
        String resultado = determinarResultado(cartaPokemon, nuevaCarta, opcionElegida);
        JOptionPane.showMessageDialog(null, resultado);
        
        if (resultado.equals("¡Has ganado!")) {
             jugadorGano = true;
            jugador.incrementarSaldo(cantidadApostada*2);
        }else{
             askAumento(true);
             JOptionPane.showMessageDialog(null, "Pachirisu se alegra de haberte ganado! (+1)Relacion");
        }

        System.out.println("Saldo:"+jugador.getSaldo());
        new MenuPrincipal().askResultado(true);
    }

    public int getWatts() {
        return Watts;
    }
    
      private int generarCartaAleatoria() {
        Random random = new Random();
        return random.nextInt(13) + 1; // Genera un número entre 1 y 13
    }
      
      private String determinarResultado(int cartaPokemon, int nuevaCarta, int opcionElegida) {
        String resultado = "";

        if (opcionElegida == 0) { // Si el usuario eligió "Más alta"
            if (nuevaCarta > cartaPokemon) {
                resultado = "¡Has ganado!";
            } else {
                resultado = "¡Has perdido!";
            }
        } else { // Si el usuario eligió "Más baja"
            if (nuevaCarta < cartaPokemon) {
                resultado = "¡Has ganado!";
            } else {
                resultado = "¡Has perdido!";
            }
        }

        return resultado;
    }
      
      public void jugarAdivinaza(List<Regalo> regalosDisponibles) throws IOException{
          //Comprueba que el pokemon tenga al menos 2 regalos en su inventario para que pueda jugar
        
        boolean jugadorGano= false;
        if (regalosDisponibles.getSize() < 2) {
       JOptionPane.showMessageDialog(null, "El Pokémon se rehúsa a jugar. Necesitas comprar al menos 2 regalos.", "Error", JOptionPane.ERROR_MESSAGE);
       return;
        }
        
        //Apuesta
       int cantidadApostada = CantidadApostada("Seleccione la cantidad de watts para apostar", jugador.getSaldo());
        // Verificar si el jugador canceló la selección o si la cantidad seleccionada excede su saldo
        if (cantidadApostada == -1 || cantidadApostada > jugador.getSaldo()) {
            JOptionPane.showMessageDialog(null, "Apuesta inválida. Por favor, seleccione una cantidad válida.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Restarle el saldo que apostó
        jugador.decrementarSaldo(cantidadApostada);

        
        // Inicializar la relación con el Pokémon
        int relacion = 0;


          
          
        String mensajeRegalos = "Regalos posibles:\n";
        for (int i = 0; i < regalosDisponibles.getSize(); i++) {
            mensajeRegalos += (i + 1) + ". " + regalosDisponibles.get(i).getNombre() + "\n";
        }
        String seleccionUsuarioStr= JOptionPane.showInputDialog(null, mensajeRegalos, "Adivina lo que estoy pensando", JOptionPane.QUESTION_MESSAGE);
        if (seleccionUsuarioStr == null) {
            return; //el usuario cancelo la operacion
        }
        
        try{
             int seleccionUsuario = Integer.parseInt(seleccionUsuarioStr.trim()) - 1; // Convertir a índice de arreglo
            if (seleccionUsuario < 0 || seleccionUsuario >= regalosDisponibles.getSize()) {
                JOptionPane.showMessageDialog(null, "Selección inválida. Por favor, seleccione un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
               // Generar un número aleatorio entre 0 y la cantidad total de regalos recibidos
            Random random = new Random();
            int nroAleatorio= random.nextInt(regalosDisponibles.getSize());
             // Comparar el número aleatorio con la selección del usuario
            if (nroAleatorio == seleccionUsuario) { //El jugador Gana
                 jugadorGano = true;
                JOptionPane.showMessageDialog(null, "¡Has adivinado! Pachirisu estaba pensando en " + regalosDisponibles.get(seleccionUsuario).getNombre() + ".", "¡Felicidades!", JOptionPane.INFORMATION_MESSAGE);
                 jugador.incrementarSaldo(cantidadApostada * 2); // Incrementar el saldo del jugador
            } else {
                JOptionPane.showMessageDialog(null, "Lo siento, Pachirisu estaba pensando en " + regalosDisponibles.get(nroAleatorio).getNombre() + "."+" (+1)Relacion", "¡Inténtalo de nuevo!", JOptionPane.INFORMATION_MESSAGE);
                askAumento(true);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error al procesar la selección. Por favor, seleccione un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
      }
    
      public boolean Aumento(){
           return Aumentar;
   }
   public void askAumento(boolean valor) {
           Aumentar = valor;
       }
   
   
      
}
