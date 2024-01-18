package com.example.projeto1.model;


public class Mesa {
    private int numero;
    private boolean disponibilidade;

    public Mesa(int tableNumber) {
        this.numero = tableNumber;
        this.disponibilidade = true;
    }

    // Getters e Setters

    public int getNumero() {
        return numero;
    }

    public boolean disponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean available) {
        disponibilidade = available;
    }


    @Override
    public String toString() {
        return "Mesa " + numero;  
    }
}
