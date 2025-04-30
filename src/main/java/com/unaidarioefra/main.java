package com.unaidarioefra;

import java.io.File;
import java.util.List;

public class main {
    public static void main(String[] args) {
        File archivo = new File("C:\\Users\\Efrain\\Desktop\\DAW1B\\Programacion\\JuegoMazmorras\\JuegoMazmorras\\juegomazmorra\\src\\main\\java\\com\\unaidarioefra\\ArchivoEnemigos.csv"); // Ajusta la ruta según tu estructura
        List<Entidad> enemigos = leercsv.leerCSV(archivo);

        for (Entidad e : enemigos) {
            System.out.println("Salud: " + e.getSalud() + ", Ataque: " + e.getAtaque() +
                               ", Defensa: " + e.getDefensa() + ", Evasión: " + e.getEvasion());
        }
    }
}