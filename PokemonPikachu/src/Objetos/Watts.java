/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author Antonella
 */
public class Watts {
    private int balance;

    public Watts(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void aumentar(int cantidad) {
        balance += cantidad;
    }

    public void disminuir(int cantidad) {
        balance -= cantidad;
    }
}