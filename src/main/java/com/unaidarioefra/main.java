package com.unaidarioefra;

public class main {
    public static void main(String[] args) {
        try {
            // Se crea un nuevo protagonista con valores validos
            Prota p = new Prota(15, 10, 13, 19);

            // Se imprime en consola la informacion del protagonista
            System.out.println(p);

        } catch (IllegalArgumentException e) {
            // Si algun valor esta fuera de rango, se captura la excepcion y se muestra un mensaje de error
            System.out.println("Error al crear el protagonista: " + e.getMessage());
        }
    }
}