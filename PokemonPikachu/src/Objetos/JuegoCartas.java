/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import java.util.Random;

/**
 *
 * @author Antonella
 */
public class JuegoCartas {
     private Pokemon pokemon;

    public JuegoCartas(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public boolean jugar(int wattsApostados, boolean esMasAlta) {
        if (wattsApostados <= 0 || wattsApostados > pokemon.getRelacion()) {
            System.out.println("Watts apostados no válidos.");
            return false;
        }

        Random random = new Random();
        int cartaPokemon = random.nextInt(13) + 1; // Carta aleatoria del Pokémon (1-13)

        int cartaUsuario = random.nextInt(13) + 1; // Carta aleatoria del usuario (1-13)

        System.out.println("El Pokémon sacó una carta: " + cartaPokemon);

        if ((esMasAlta && cartaUsuario > cartaPokemon) || (!esMasAlta && cartaUsuario < cartaPokemon)) {
            System.out.println("¡Felicidades! ¡Has ganado!");
            pokemon.aumentarRelacion(wattsApostados * 2); // Duplica la relación si gana
            return true;
        } else {
            System.out.println("Lo siento, has perdido.");
            pokemon.disminuirRelacion(wattsApostados); // Disminuye la relación si pierde
            return false;
        }
    }
}
