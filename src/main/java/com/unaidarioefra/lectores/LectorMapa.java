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
            ArrayList<String> datosMapa = new ArrayList<>();

            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("#")) {
                    if (linea.startsWith("#suelo:")) {
                        suelo = linea.split(":")[1].trim().replace("src\\main\\resources", "");
                    } else if (linea.startsWith("#pared:")) {
                        pared = linea.split(":")[1].trim().replace("src\\main\\resources", "");
                    } else if (linea.startsWith("#nivel:")) {
                        nivel = linea.split(":")[1].trim();
                    } else if (linea.startsWith("#tamanoX:")) {
                        tamanoX = Integer.parseInt(linea.split(":")[1].trim());
                    } else if (linea.startsWith("#tamanoy:")) {
                        tamanoY = Integer.parseInt(linea.split(":")[1].trim());
                        datosMapa.clear(); // Reiniciamos las filas para un nuevo mapa
                    }
                } else if (!linea.trim().isEmpty()) {
                    datosMapa.add(linea.trim());
                    // Si ya leímos todas las filas
                    if (datosMapa.size() == tamanoY) {
                        int[][] mapa = new int[tamanoY][tamanoX];
                        for (int i = 0; i < tamanoY; i++) {
                            char[] fila = datosMapa.get(i).toCharArray();
                            for (int j = 0; j < tamanoX; j++) {
                                mapa[i][j] = Character.getNumericValue(fila[j]);
                            }
                        }
                        // Crear y añadir el mapa
                        listaMapas.add(new Mapa(suelo, pared, nivel, mapa));
                        datosMapa.clear(); // Prepararse para otro posible mapa
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaMapas;
    }
}
