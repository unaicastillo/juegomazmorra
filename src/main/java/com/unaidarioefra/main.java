package com.unaidarioefra;

public class main {
    public static void main(String[] args) {
        try {
            // Se crea un nuevo protagonista con valores válidos
            Prota p = new Prota(15, 10, 70, 25);

            // Se imprime en consola la información del protagonista
            System.out.println(p);

        } catch (IllegalArgumentException e) {
            // Si algún valor está fuera de rango, se captura la excepción y se muestra un mensaje de error
            System.out.println("Error al crear el protagonista: " + e.getMessage());
        }
    }
}