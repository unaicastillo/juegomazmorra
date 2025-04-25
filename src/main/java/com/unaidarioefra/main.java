package com.unaidarioefra;

public class main {
    public static void main(String[] args) {
        try {
            Prota p = new Prota(15, 10, 70, 25);
            System.out.println(p);
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear el protagonista: " + e.getMessage());
        }
    }
}
