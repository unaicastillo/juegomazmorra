package com.unaidarioefra.lectores;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.unaidarioefra.Modelo.Mapa;

public class LectorMapa {
    public static ArrayList<Mapa> leerMapa() {
        ArrayList<Mapa> listaMapas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/com/unaidarioefra/files/Mapa.unai"))) {
            String linea;
            String suelo = null, pared = null, nivel = null;
            int tamanoX = 0, tamanoY = 0;
            int[][] mapa = null;

            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("#")) {
                    // Leer metadatos
                    if (linea.startsWith("#suelo:")) {
                        suelo = linea.split(":")[1];
                    } else if (linea.startsWith("#pared:")) {
                        pared = linea.split(":")[1];
                    } else if (linea.startsWith("#nivel:")) {
                        nivel = linea.split(":")[1];
                    } else if (linea.startsWith("#tamanoX:")) {
                        tamanoX = Integer.parseInt(linea.split(":")[1]);
                    } else if (linea.startsWith("#tamanoy:")) {
                        tamanoY = Integer.parseInt(linea.split(":")[1]);
                        mapa = new int[tamanoY][tamanoX];
                    }
                } else if (!linea.isEmpty() && mapa != null) {
                    // Leer matriz del mapa
                    for (int i = 0; i < tamanoY; i++) {
                        char[] fila = linea.toCharArray();
                        for (int j = 0; j < tamanoX; j++) {
                            mapa[i][j] = Character.getNumericValue(fila[j]);
                        }
                        if (i < tamanoY - 1) {
                            linea = br.readLine();
                        }
                    }
                    // Crear el objeto Mapa y añadirlo a la lista
                    listaMapas.add(new Mapa(suelo, pared, nivel, mapa));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaMapas;
    }
}
